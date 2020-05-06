package com.example.bahmed.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static boolean b = false;
    public static String re = "0";
    public static String ope = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resl = (TextView) findViewById(R.id.aff);
        resl.setText("0");
        TextView op = (TextView) findViewById(R.id.op);
        op.setText("0");

    }

    public void one(View v) {
        aff("1");
    }

    public void two(View v) {
        aff("2");
    }

    public void three(View v) {
        aff("3");
    }

    public void four(View v) {
        aff("4");
    }

    public void five(View v) {
        aff("5");
    }

    public void six(View v) {
        aff("6");
    }

    public void seven(View v) {
        aff("7");
    }

    public void eight(View v) {
        aff("8");
    }

    public void nine(View v) {
        aff("9");
    }

    public void zero(View v) {
        aff("0");
    }

    public void ac(View v) {
        TextView resultat = (TextView) findViewById(R.id.aff);
        TextView op = (TextView) findViewById(R.id.op);

        resultat.setText("0");

        op.setText("0");

    }

    public void realnumbre(View v) {
        TextView resultat = (TextView) findViewById(R.id.aff);
        try {
            long i = Long.parseLong(resultat.getText().toString());
            i = -1 * i;
            resultat.setText(String.valueOf(i));
        } catch (NumberFormatException e) {
            double i = Double.parseDouble(resultat.getText().toString());
            i = -1 * i;
            resultat.setText(String.valueOf(i));
        }


    }

    public void back(View v) {

        TextView resultat = (TextView) findViewById(R.id.aff);
        TextView op = (TextView) findViewById(R.id.op);
        if (b) {
            b = false;
            resultat.setText(re);
            op.setText(ope);
        } else {
            String op1 = op.getText().toString();
            String s = resultat.getText().toString();
            if (s.equals("0")) {
                if ((op1.equals("0")) || (op1.equals("")) || (op1.equals(null)))
                    Toast.makeText(getApplicationContext(), "There is nothing to delete", Toast.LENGTH_SHORT).show();
                else {
                    if (op1.length() == 1) {
                        resultat.setText("0");
                        op.setText("0");
                    } else {
                        op.setText(op1.substring(0, op1.length() - 1));
                        int i = cal.lastposop2(op1.substring(0, op1.length() - 1));
                        if (i == -1) {
                            op.setText("0");
                            resultat.setText(op1.substring(0, op1.length() - 1));
                        } else {
                            op.setText(op1.substring(0, i + 1));
                            resultat.setText(op1.substring(i + 1, op1.length() - 1));
                        }
                    }


                }
            } else {
                if (s.length() == 1) {
                    resultat.setText(null);
                    resultat.setText("0");
                } else
                    resultat.setText(s.substring(0, s.length() - 1));
            }
        }
    }

    public void poursont(View v) {
        TextView resltate = (TextView) findViewById(R.id.aff);
        resltate.setText(String.valueOf(Double.parseDouble(resltate.getText().toString()) / 100));
    }

    public void plus(View v) {
        opaff("+");
    }

    public void sour(View v) {
        opaff("-");
    }

    public void mult(View v) {
        opaff("X");
    }

    public void div(View v) {
        opaff("/");
    }

    public void piont(View v) {
        TextView resl = (TextView) findViewById(R.id.aff);
        if (cal.nbrpoint(resl.getText().toString()))
            Toast.makeText(getApplicationContext(), "erreur", Toast.LENGTH_SHORT).show();
        else
            aff(".");
    }

    public void equle(View v) {
        b = true;
        TextView resultat = (TextView) findViewById(R.id.aff);
        re = resultat.getText().toString();

        TextView op = (TextView) findViewById(R.id.op);
        ope = op.getText().toString();
        if (op.getText().toString().equals("0"))
            resultat.setText(cal.resultat(resultat.getText().toString()));
        else
            resultat.setText(cal.resultat(op.getText().toString() + resultat.getText().toString()));
        op.setText("0");
    }

    public void aff(String a) {
        TextView resultat = (TextView) findViewById(R.id.aff);
        TextView op = (TextView) findViewById(R.id.op);
        if (b) {
            b = false;
            resultat.setText(a);
            op.setText("0");
        } else {
            String aff = resultat.getText().toString();
            if (aff == "0") {
                resultat.setText(null);
                resultat.setText(a);
            } else
                resultat.setText(aff + a);
        }
    }

    public void opaff(String s) {
        b=false;
        TextView resultate = (TextView) findViewById(R.id.aff);
        String res = resultate.getText().toString();
        TextView op = (TextView) findViewById(R.id.op);
        String op1 = op.getText().toString();
        if ((op1 == "") || (op1 == "0")) {

            op.setText(res + s);

            resultate.setText("0");
        } else {

            op.setText(op1 + res + s);

            resultate.setText("0");
        }


    }

}