package com.juara.android_fundamental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DebuggerActivity extends AppCompatActivity {

    private static final String TAG = "CalculatorActivity";
    private EditText nilai_a, nilai_b;
    private Button plus, min, kali, bagi;
    private TextView hasil;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);
        nilai_a = findViewById(R.id.et_nilai_a);
        nilai_b = findViewById(R.id.et_nilai_b);
        plus = findViewById(R.id.btn_plus);
        min = findViewById(R.id.btn_min);
        kali = findViewById(R.id.btn_kali);
        bagi = findViewById(R.id.btn_bagi);
        hasil = findViewById(R.id.txtHasil);

        calculator = new Calculator();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(Calculator.Operator.ADD);
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(Calculator.Operator.SUB);
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute(Calculator.Operator.MUL);
                } catch (IllegalArgumentException iae){
                    Log.e(TAG, "IllegalArgumentException", iae);
                    hasil.setText(getString(R.string.computationError));
                }
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(Calculator.Operator.DIV);
            }
        });

    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(nilai_a);
            operandTwo = getOperand(nilai_b);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            hasil.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        calculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        calculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        calculator.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        calculator.mul(operandOne, operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        hasil.setText(result);
    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        String operandText = operandEditText.getText().toString();
        if (TextUtils.isEmpty(operandText)) {
            throw new NumberFormatException("Operand cannot be empty!");
        }
        return operandText;
    }
}