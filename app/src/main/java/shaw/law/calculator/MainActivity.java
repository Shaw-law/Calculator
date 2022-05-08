package shaw.law.calculator;

import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
                display.setText("");
            }
        });
    }

    public void updateText(String textToAdd) {
        int cursorPos = display.getSelectionStart();

        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText("");
        }

        String leftHalf = display.getText().toString().substring(0, cursorPos);
        String rightHalf = display.getText().toString().substring(cursorPos);
        String finalText = leftHalf + textToAdd + rightHalf;

        display.setText(finalText);
        cursorPos += 1;
        display.setSelection(cursorPos);
    }

    public void oneBtn(View view) {
        updateText("1");
    }

    public void twoBtn(View view) {
        updateText("2");
    }

    public void threeBtn(View view) {
        updateText("3");
    }

    public void fourBtn(View view) {
        updateText("4");
    }

    public void fiveBtn(View view) {
        updateText("5");
    }

    public void sixBtn(View view) {
        updateText("6");
    }

    public void sevenBtn(View view) {
        updateText("7");
    }

    public void eightBtn(View view) {
        updateText("8");
    }

    public void nineBtn(View view) {
        updateText("9");
    }

    public void zeroBtn(View view) {
        updateText("0");
    }

    public void decimalBtn(View view) {
        updateText(".");
    }

    public void plusBtn(View view) {
        updateText("+");
    }

    public void minusBtn(View view) {
        updateText("-");
    }

    public void multiplyBtn(View view) {
        updateText("*");
    }

    public void divideBtn(View view) {
        updateText("/");
    }

    public void powerBtn(View view) {
        updateText("^");
    }

    public void equalBtn(View view) {
        String exp = display.getText().toString();

        Expression userExp = new Expression(exp);
        String result = new String(String.valueOf(userExp.calculate()));

        display.setText(result);
        int cursorPos = display.getSelectionEnd();
        display.setSelection(cursorPos);
    }

    public void clear(View view) {
        display.getText().clear();
    }

    // Function for clear button
    public void delete(View view) {
        String emptyText = display.getText().toString().trim();
        String prevText = getString(R.string.display);

        if (TextUtils.isEmpty(emptyText)) {
            Toast.makeText(this, "Already Empty!!!", Toast.LENGTH_SHORT).show();
            display.setText(prevText);
        } else if (getString(R.string.display).equals(display.getText().toString())) {
            Toast.makeText(this, "Nothing to Clear!!!", Toast.LENGTH_SHORT).show();
        } else {
            String text = display.getText().toString();
            String temp = text.substring(0, text.length() - 1);
            display.setText(temp);
        }
    }

    public void modulusBtn(View view) {
        updateText("%");
    }

    public void toggle(View view) {
        String exp = display.getText().toString().trim();
        int expInt = Integer.parseInt(exp);

        if (expInt == 0) {
            Toast.makeText(this, "Nothing to Change!!!", Toast.LENGTH_SHORT).show();
        } else if (expInt < 0) {
            expInt = -expInt;
        } else if (expInt > 0) {
            expInt = -expInt;
        }
        display.setText(String.valueOf(expInt));
        int cursorPos = display.getSelectionEnd();

        display.setSelection(cursorPos);
    }

}