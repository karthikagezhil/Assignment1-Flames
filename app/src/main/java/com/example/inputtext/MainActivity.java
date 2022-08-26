package com.example.inputtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String getName1(View v){
        TextView t = findViewById(R.id.Name1);
        String input1 = t.getText().toString();
        //Log.d("NAME", input1);
        return input1;
    }
    public String getName2(View v){
        TextView t = findViewById(R.id.Name2);
        String input2 = t.getText().toString();
        //Log.d("NAME", input2);
        return input2;
    }
    public void calculation(View v){
        String name1 = getName1(v);
        String name2 = getName2(v);
        Log.d("NAME1", name1);
        Log.d("NAME2", name2);
        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();
        StringBuilder sb1 = new StringBuilder(name1);// converting to string builder
        StringBuilder sb2 = new StringBuilder(name2);
        int m=sb1.length();
        int n=sb2.length();
        for(int i=0; i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                if(sb1.charAt(i) == sb2.charAt(j))
                {
                    sb1.replace(i, i+1, "0"); // replacing matching characters into "0"
                    sb2.replace(j,j+1,"0");
                }
            }
        }

        int x1=0;
        int y1=0;
        String s1="";
        String s2="";
        s1 = sb1.toString();
        s2 = sb2.toString();
        for(int i=0;i<s1.length();i++){ //length of string to remove 0 and find the length
            if(s1.charAt(i)!='0'){
                //System.out.print(" "+s1.charAt(i));
                Log.d("NAME_3", String.valueOf(s1.charAt(i)));
                x1 +=1;

            }
        }
        Log.d("NAME_4", String.valueOf(x1));

        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)!='0'){
                //System.out.print(" "+s2.charAt(i));
                Log.d("NAME_5", String.valueOf(s2.charAt(i)));
                y1 +=1;

            }
        }
        Log.d("NAME_6", String.valueOf(y1));
        int x = x1+y1; // total length of remaining characters in both the strings
        Log.d("NAME_7", String.valueOf(x));

        String flames = "flames";
        StringBuilder sb3 = new StringBuilder(flames);
        char flameResult = 0;
        while(sb3.length()!=1)
        {
            int y = x%sb3.length();
            String temp;

            if(y!=0)
            {
                temp = sb3.substring(y)+sb3.substring(0, y-1); // taking substring (counting purpose)

            }
            else
            {
                temp = sb3.substring(0, sb3.length()-1); // taking substring (counting purpose)

            }
            sb3 = new StringBuilder(temp);
            flameResult = sb3.charAt(0);
            Log.d("NAME_8", String.valueOf(flameResult));
        }

        Log.d("NAME_9", String.valueOf(flameResult));

        TextView res = (TextView) findViewById(R.id.result);
        switch (flameResult)
        {
            case 'f':
                Log.d("NAME_sw", "Friends");
                break;
            case 'l':
                Log.d("NAME_sw", "Love");
                res.setText("Love");
                break;
            case 'a':
                Log.d("NAME_sw", "Anger");
                res.setText("Anger");
                break;
            case 'm':
                Log.d("NAME_sw", "Marriage");
                res.setText("Marriage");
                break;
            case 'e':
                Log.d("NAME_sw", "Enemies");
                res.setText("Enemies");
                break;
            case 's':
                Log.d("NAME_sw", "Siblings");
                res.setText("Siblings");
                break;

        }
    }
}