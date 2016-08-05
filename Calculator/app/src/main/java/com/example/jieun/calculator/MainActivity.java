package com.example.jieun.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList arrayList = new ArrayList();
    int operCount = 0;
    String operation = null;

    String thing1 = null;//첫번째 연산 할 숫자
    String thing2 = null;//부호 다음에 나올 숫자
    String thing3 = null;//결과값


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_c = (Button) findViewById(R.id.btn_c);
        Button btn_dell = (Button) findViewById(R.id.btn_dell);

        btn_c.setOnClickListener(this);
        btn_dell.setOnClickListener(this);

        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        Button btn_0 = (Button) findViewById(R.id.btn_0);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_subtract = (Button) findViewById(R.id.btn_subtract);
        Button btn_multiple = (Button) findViewById(R.id.btn_multiple);
        Button btn_divi = (Button) findViewById(R.id.btn_divi);
        Button btn_is = (Button) findViewById(R.id.btn_is);
        Button btn_dot = (Button) findViewById(R.id.btn_dot);

        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiple.setOnClickListener(this);
        btn_divi.setOnClickListener(this);
        btn_is.setOnClickListener(this);
        btn_dot.setOnClickListener(this);




    }

    public void onClick(View v){
        //버튼을 클릭했을 때의 내용을 화면에 보여준다
        TextView tv = (TextView) findViewById(R.id.resultView);

        switch (v.getId()){

            //C버튼 클릭시 reseltView에 내용 삭제
            case R.id.btn_c:
                arrayList.clear();//array비운다
                tv.setText("");//화면지운다
                break;

            //dell버튼 클릭시 앞의 한 자리만 내용 삭제
            case R.id.btn_dell:
                if (tv.getText().toString() != ""){
                    tv.setText(tv.getText().toString().substring(0, tv.getText().toString().length()-1));
                }
            break;

            //숫자 버튼 클릭하면!
            case R.id.btn_0:
                tv.setText(tv.getText().toString() + "0");
                break;
            case R.id.btn_1:
                tv.setText(tv.getText().toString() + "1");
                break;
            case R.id.btn_2:
                tv.setText(tv.getText().toString() + "2");
                break;
            case R.id.btn_3:
                tv.setText(tv.getText().toString() + "3");
                break;
            case R.id.btn_4:
                tv.setText(tv.getText().toString() + "4");
                break;
            case R.id.btn_5:
                tv.setText(tv.getText().toString() + "5");
                break;
            case R.id.btn_6:
                tv.setText(tv.getText().toString() + "6");
                break;
            case R.id.btn_7:
                tv.setText(tv.getText().toString() + "7");
                break;
            case R.id.btn_8:
                tv.setText(tv.getText().toString() + "8");
                break;
            case R.id.btn_9:
                tv.setText(tv.getText().toString() + "9");
                break;

            //화면에 떠있는 거 먼저 list에 넣고 operCount를 변하게 하고 그다음 숫자를 받아
            case R.id.btn_add:
                //arrayList.add(tv.getText().toString());
                thing1 = tv.getText().toString();
                tv.setText("");
                operCount = 1;
                operation = "+";
                break;
            case R.id.btn_subtract:
                arrayList.add(tv.getText().toString());
                tv.setText("");
                operCount = 2;
                operation = "-";
                break;
            case R.id.btn_multiple:
                arrayList.add(tv.getText().toString());
                tv.setText("");
                operation = "*";
                operCount = 3;
                break;
            case R.id.btn_divi:
                arrayList.add(tv.getText().toString());
                tv.setText("");
                operCount = 4;
                operation = "/";
                break;

            case R.id.btn_dot:
                if (tv.getText().toString() != "") {//화면이 빈칸이 아닐 경우에만
                    tv.setText(tv.getText().toString() + ".");
                }
                break;

            case R.id.btn_is:
                //연산에 따라 case로 다른작용
                //숫자(thing1) + 부호(switch) + 숫자(thing2) + 는(thing3)


                //더블계산인가?
                boolean isDouble = false;

                //float로 파싱하는거
                double floatListS = 0;//list의 0번째
                double floatViewS = 0;//뷰의 0번째
                double floatResult = 0;

                //int로 파싱하는거
                int intListS = 0;
                int intViewS = 0;
                int intResult = 0;

                //결과값을 String으로
                String val = "";


                if(thing1==null){//thing1에 아무것도 없을 때
                    tv.setText("");
                }else{//차있을때
                    String listS = thing1;//부호를 누르면서 사라진 숫자 넣어놓는 임시공간
                    String viewS = tv.getText().toString();//연산기호 뒤에 새로 써진 숫자 내용 받아오기


                    //listS, viewS에 소수점 들어갈 때!
                    if(listS.contains(".")||viewS.contains(".")){
                        isDouble = true;
                        floatListS = Float.parseFloat(listS);
                        floatViewS = Float.parseFloat(viewS);
                    }else{//소수점 안들어갈 때 그냥 int로
                        isDouble = false;
                        intListS = Integer.parseInt(listS);
                        intViewS = Integer.parseInt(viewS);
                    }

                    tv.setText("");//화면 초기화
                    //연산시작!
                    switch (operCount){
                        case 0:
                            tv.setText("");
                            break;
                        case 1:
                            if(operation=="+"||isDouble){//더블 더하기

                                floatResult = floatListS + floatViewS;
                                val = String.valueOf(floatResult);

                            }else if(operation=="+"||!isDouble){//인트더하기

                                intResult = intListS+intViewS;
                                val = String.valueOf(intResult);

                            }
                            tv.setText(val);
                            arrayList.clear();
                            break;
                        case 2:
                            if(operation=="-"||isDouble){//더블빼기

                                floatResult = floatListS - floatViewS;
                                val = String.valueOf(floatResult);

                            }else if(operation=="-"||!isDouble){//인트빼기

                                intResult = intListS-intViewS;
                                val = String.valueOf(intResult);

                            }
                            tv.setText(val);
                            arrayList.clear();
                            break;
                        case 3:

                            if(operation=="*"||isDouble){//더블곱하기

                                floatResult = floatListS * floatViewS;
                                val = String.valueOf(floatResult);

                            }else if(operation=="*"||!isDouble){//인트곱하기

                                intResult = intListS * intViewS;
                                val = String.valueOf(intResult);

                            }
                            tv.setText(val);
                            arrayList.clear();
                            break;
                        case 4:

                            if(operation=="/"||isDouble){//더블곱하기

                                floatResult = floatListS / floatViewS;
                                val = String.valueOf(floatResult);

                            }else if(operation=="/"||!isDouble){//인트곱하기

                                intResult = intListS / intViewS;
                                val = String.valueOf(intResult);

                            }
                            tv.setText(val);
                            arrayList.clear();
                            break;
                    }
                }
                break;
        }

    }
}
