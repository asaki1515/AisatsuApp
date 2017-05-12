package jp.techacademy.minegishi.asaki.aisatsuapp;

        import android.app.TimePickerDialog;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //メンバ変数
    TextView mTextView1;  // 時間表示
    TextView mTextView2;  // あいさつ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);  // TimePickerDialog用ボタン
        button1.setOnClickListener(this);

        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);

    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
        //Log.d("UI_PARTS", String.valueOf(hour_data) + ":" + String.valueOf(minute_data));
    }

    private void showTimePickerDialog() {
        // コンストラクタ
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,  // Activity
                new TimePickerDialog.OnTimeSetListener() {  //the view associated with this listener：インタフェース
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {  //OnTimeSetListenerのonTimeSetメソッド

                        // 設定した時間を表示
                        if (minute == 0){  // 分が0だった時だけ、表示が気持ち悪いので0を追加表示
                            mTextView1.setText(String.valueOf(hourOfDay) + ":0" + String.valueOf(minute));
                        }else {
                            mTextView1.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        }

                        // 設定時間に応じて、あいさつを表示
                        if (hourOfDay >= 2 && hourOfDay <= 9){
                            mTextView2.setText( "おはよう(^０^)");
                        }else if (hourOfDay >= 10 && hourOfDay <= 17){
                            mTextView2.setText( "こんにちは(・_・)");
                        }else if ((hourOfDay >= 1 && hourOfDay < 2) || (hourOfDay >= 18 && hourOfDay <= 23)){
                            mTextView2.setText( "こんばんは(＊_＊)");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);  // trueは24時間表記、falseは午前、午後を選択する形
        timePickerDialog.show();  // showメソッドでTimePickerDialogを表示
    }


}
