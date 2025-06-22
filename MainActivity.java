package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView resultsTv;
    TextView workingsTv;

    String formula = "";
    String workings = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews(){
        workingsTv = (TextView) findViewById(R.id.workingsTextView);
        resultsTv = (TextView) findViewById(R.id.workingsTextView);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTv.setText(workings);
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^') {
                indexOfPowers.add(i);
            }
        }
        formula = workings;
        tempFormula = workings;
        for (int i = 0; i < indexOfPowers.size(); i++) {
            changeFormula(indexOfPowers.get(i));
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";
        for (int i = index + 1; i < workings.length(); i++) {
            if (isNumeric(workings.charAt(i))) {
                numberRight = numberRight + workings.charAt(i);
            } else
                break;
        }
        for (int i = index - 1; i >= 0; i++) {
            if (isNumeric(workings.charAt(i))) {
                numberLeft = workings.charAt(i) + numberLeft;
            } else
                break;
        }
        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    private boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.') {
            return true;
        }
        return false;
    }

    public void clearOnClick(View view){
        workingsTv.setText("");
        resultsTv.setText("");
        workings = "";
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketsOnClick(View view){
        if(leftBracket == true){
            setWorkings("(");
            leftBracket = false;
        }
        else {
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void powerOfOnClick(View view){
        setWorkings("^");
    }

    public void oneOnClick(View view){
        setWorkings("1");
    }

    public void twoOnClick(View view){
        setWorkings("2");
    }

    public void threeOnClick(View view){
        setWorkings("3");
    }

    public void fourOnClick(View view){
        setWorkings("4");
    }

    public void fiveOnClick(View view){
        setWorkings("5");
    }

    public void sixOnClick(View view){
        setWorkings("6");
    }

    public void sevenOnClick(View view){
        setWorkings("7");
    }

    public void eightOnClick(View view){
        setWorkings("8");
    }

    public void nineOnClick(View view){
        setWorkings("9");
    }

    public void zeroOnClick(View view){
        setWorkings("0");
    }

    public void divisionOnClick(View view){
        setWorkings("/");
    }

    public void timesOnClick(View view){
        setWorkings("x");
    }

    public void minusOnClick(View view){
        setWorkings("-");
    }

    public void plusOnClick(View view){
        setWorkings("+");
    }

    public void equalsOnClick(View view){
        setWorkings("=");
    }

    public void decimalOnClick(View view){
        setWorkings(".");
    }

}