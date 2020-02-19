package helloworld.kimbriant.onclicklistenerlabthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView topLeftView;
    TextView topRightView;
    TextView bottomLeftView;
    TextView bottomRightView;
    SharedPreferences clickCounter;
    SharedPreferences.Editor clickCounterEditor;
    SeekBar sizebar;
    Button clearPref;
    Context context;
    int duration;

    private View.OnClickListener WackyListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.topLeftView:
                    Log.v("Top left view", "1");
                    if (!clickCounter.contains("TLV")) {
                        clickCounterEditor.putInt("TLV", 1);
                        clickCounterEditor.commit();
                        CharSequence toastman = "Top left view pressed. " + Integer.toString(1) + " time.";
                        Toast toastah = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastah.show();
                        Log.v("ah", "ah");
                    } else {
                        clickCounterEditor.putInt("TLV", clickCounter.getInt("TLV", 1) + 1);
                        CharSequence toastman = "Top left view pressed. " + Integer.toString(clickCounter.getInt("TLV", 1)) + " times.";
                        Toast toastmanner = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        clickCounterEditor.commit();
                        Log.v("topLeftView", "" + clickCounter.getInt("TLV", 420));
                        toastmanner.show();
                    }
                    break;

                case R.id.topRightView:
                    Log.v("Top right view", "2");
                    if (!clickCounter.contains("TRV")) {
                        clickCounterEditor.putInt("TRV", 1);
                        clickCounterEditor.commit();
                        Log.v("ah", "ah");
                        CharSequence toastman = "Top right view pressed. " + Integer.toString(1) + " time.";
                        Toast toastah = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastah.show();
                    } else {
                        clickCounterEditor.putInt("TRV", clickCounter.getInt("TRV", 1) + 1);
                        clickCounterEditor.commit();
                        Log.v("topRightView", "" + clickCounter.getInt("TRV", 420));
                        CharSequence toastman = "Top right view pressed. " + Integer.toString(clickCounter.getInt("TRV", 1)) + " times.";
                        Toast toastmannerwow = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastmannerwow.show();
                    }
                    break;

                case R.id.bottomLeftView:
                    Log.v("Bottom left view", "3");
                    if (!clickCounter.contains("BLV")) {
                        clickCounterEditor.putInt("BLV", 1);
                        clickCounterEditor.commit();
                        Log.v("ah", "ah");
                        CharSequence toastman = "Bottom left view pressed. " + Integer.toString(1) + " time.";
                        Toast toastah = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastah.show();
                    } else {
                        clickCounterEditor.putInt("BLV", clickCounter.getInt("BLV", 1) + 1);
                        clickCounterEditor.commit();
                        Log.v("bottomLeftView", "" + clickCounter.getInt("BLV", 420));
                        CharSequence toastman = "Bottom left view pressed. " + Integer.toString(clickCounter.getInt("BLV", 1)) + " times.";
                        Toast toastmannerwow = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastmannerwow.show();
                    }
                    break;

                case R.id.bottomRightView:
                    Log.v("Bottom right view", "4");
                    if (!clickCounter.contains("BRV")) {
                        clickCounterEditor.putInt("BRV", 1);
                        clickCounterEditor.commit();
                        Log.v("ah", "ah");
                        CharSequence toastman = "Bottom right view pressed. " + Integer.toString(1) + " time.";
                        Toast toastah = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastah.show();
                    } else {
                        clickCounterEditor.putInt("BRV", clickCounter.getInt("BRV", 1) + 1);
                        clickCounterEditor.commit();
                        Log.v("bottomRightView", "" + clickCounter.getInt("BRV", 420));
                        CharSequence toastman = "Bottom right view pressed. " + Integer.toString(clickCounter.getInt("BRV", 1)) + " times.";
                        Toast toastmannerwow = Toast.makeText(context, toastman, Toast.LENGTH_SHORT);
                        toastmannerwow.show();
                    }
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeftView = findViewById(R.id.topLeftView);
        topRightView = findViewById(R.id.topRightView);
        bottomLeftView = findViewById(R.id.bottomLeftView);
        bottomRightView = findViewById(R.id.bottomRightView);
        sizebar = (SeekBar) findViewById(R.id.sizeBar);
        clearPref = findViewById(R.id.clearPlease);
        final ArrayList<TextView> alTv = new ArrayList<>();
        alTv.add(topLeftView);
        alTv.add(topRightView);
        alTv.add(bottomLeftView);
        alTv.add(bottomRightView);
        for( TextView textView : alTv) {
            textView.setOnClickListener(WackyListener);
        }

        clickCounter = PreferenceManager.getDefaultSharedPreferences(this);
        clickCounterEditor = clickCounter.edit();
        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;

        sizebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int size = (int)Math.ceil(14 * Math.log(progress));
                Log.v("seekbar", Integer.toString(size));
                for(TextView textView : alTv) {
                    textView.setTextSize(size);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        clearPref.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clickCounterEditor.clear();
                clickCounterEditor.commit();
                Log.v("clickCounter", "clear");
                return true;
            }
        });
    }

            }