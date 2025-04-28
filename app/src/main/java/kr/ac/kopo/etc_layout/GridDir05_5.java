package kr.ac.kopo.etc_layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridDir05_5 extends AppCompatActivity {
    EditText edit1, edit2;
    Button[] btnNums = new Button[10];
    Button btnPlus, btnMinus, btnMultiply, btnDivide;
    TextView textResult;
    int[] btnNumIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    int[] btnOpIds = {R.id.plus, R.id.minus, R.id.multiply, R.id.divide};
    String num1 = "", num2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.grid_dir05_5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);
        textResult = findViewById(R.id.result);

        for (int i = 0; i < btnNums.length; i++) {
            btnNums[i] = findViewById(btnNumIds[i]);
        }


        for (int i = 0; i < btnNums.length; i++) {
            final int index;
            index = i;

            btnNums[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (edit1.isFocused()) {
                        num1 = edit1.getText().toString() + btnNums[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString() + btnNums[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 Editext를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMultiply.setOnClickListener(btnListener);
        btnDivide.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button eventBtn = (Button) v;
            String editStr1 = edit1.getText().toString();
            String editStr2 = edit2.getText().toString();
            int editNum1 = Integer.parseInt(editStr1);
            int editNum2 = Integer.parseInt(editStr2);
            int result = 0;

            if (eventBtn == btnPlus) {
                result = editNum1 + editNum2;
            } else if (eventBtn == btnMinus) {
                result = editNum1 - editNum2;
            } else if (eventBtn == btnMultiply) {
                result = editNum1 * editNum2;
            } else {
                result = editNum1 / editNum2;
            }
            textResult.setText("계산결과:"+result);
        }
    };
}