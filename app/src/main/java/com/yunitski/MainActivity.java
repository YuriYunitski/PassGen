package com.yunitski;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etGen, length;
    Button btnGen, plusBtn, minusBtn;
    ImageButton copyBtn;
    CheckBox up, low, nums, sym, copy;
    int lenPass;
    SharedPreferences sharedPreferences;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    final String SAVED_UP = "saved_up";
    final String SAVED_LOW = "saved_low";
    final String SAVED_SYM = "saved_sym";
    final String SAVED_NUM = "saved_num";
    final String SAVED_LEN = "saved_len";
    final String SAVED_PASS = "saved_pass";
    final String SAVED_COPY = "saved_copy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGen = findViewById(R.id.etPass);
        length = findViewById(R.id.lengthPass);
        btnGen = findViewById(R.id.generate);
        btnGen.setOnClickListener(this);
        plusBtn = findViewById(R.id.plus);
        plusBtn.setOnClickListener(this);
        minusBtn = findViewById(R.id.minus);
        minusBtn.setOnClickListener(this);
        up = findViewById(R.id.upper);
        low = findViewById(R.id.lower);
        nums = findViewById(R.id.nums);
        sym = findViewById(R.id.symbs);
        copy = findViewById(R.id.auto_copy);
        copyBtn = findViewById(R.id.copy_btn);
        copyBtn.setOnClickListener(this);
        length.setText("" + 6);
        listView = findViewById(R.id.list_view);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String s = arrayList.get(position);
                ClipData clip = ClipData.newPlainText("copied_text", s);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Пароль скопирован в буфер", Toast.LENGTH_SHORT).show();
            }
        });
        load();
    }

    @Override
    protected void onStart() {
        super.onStart();
        etGen.clearFocus();
        length.clearFocus();
    }

    @Override
    protected void onStop() {
        super.onStop();
        save();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }

    private void saver(String s){
        if (copy.isChecked()) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("copied_text", s);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Пароль скопирован в буфер", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.generate:
            if (!length.getText().toString().isEmpty()) {
                lenPass = Integer.parseInt(length.getText().toString());
                if (up.isChecked() && !low.isChecked() && !sym.isChecked() && !nums.isChecked()) {
                    String s = Pass.getUpperOnly(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (low.isChecked() && !up.isChecked() && !sym.isChecked() && !nums.isChecked()) {
                    String s = Pass.getLowerOnly(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (sym.isChecked() && !up.isChecked() && !low.isChecked() && !nums.isChecked()) {
                    String s = Pass.getSymOnly(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (nums.isChecked() && !sym.isChecked() && !up.isChecked() && !low.isChecked()) {
                    String s = Pass.getNumsOnly(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && low.isChecked() && sym.isChecked() && nums.isChecked()) {
                    String s = Pass.generatePassWithAllChecks(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && low.isChecked() && !sym.isChecked() && !nums.isChecked()) {
                    String s = Pass.getLowAndUp(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && sym.isChecked() && !low.isChecked() && !nums.isChecked()) {
                    String s = Pass.getUpAndSym(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && !low.isChecked() && !sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getUpAndNum(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && low.isChecked() && sym.isChecked() && !nums.isChecked()) {
                    String s = Pass.getLowAndUpAndSym(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && !low.isChecked() && sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getUpAndSymAndNum(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (!up.isChecked() && low.isChecked() && sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getSymAndNumAndLow(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (up.isChecked() && low.isChecked() && !sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getLowAndUpAndNum(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (!up.isChecked() && low.isChecked() && !sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getLowAndNum(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (!up.isChecked() && low.isChecked() && sym.isChecked() && !nums.isChecked()) {
                    String s = Pass.getLowAndSym(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                } else if (!up.isChecked() && !low.isChecked() && sym.isChecked() && nums.isChecked()) {
                    String s = Pass.getNumAndSym(lenPass).toString();
                    etGen.setText(s);
                    saver(s);
                }
            } else {
                Toast.makeText(this, "введите длину", Toast.LENGTH_SHORT).show();
            }
                arrayAdapter.insert(etGen.getText().toString(), 0);
            break;
            case R.id.plus:
                int currLen = Integer.parseInt(length.getText().toString());
                currLen++;
                length.setText(""+currLen);
                break;
            case R.id.minus:
                int currLenM = Integer.parseInt(length.getText().toString());
                if (currLenM > 1){
                    currLenM--;
                    length.setText(""+currLenM);
                    break;
                }
                else {
                    Toast.makeText(this, "длина пароля меньше 1", Toast.LENGTH_SHORT).show();
                }
            case R.id.copy_btn:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String s = etGen.getText().toString();
                ClipData clip = ClipData.newPlainText("copied_text", s);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Пароль скопирован в буфер", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI() {


    }

    void save() {
        String savePass = etGen.getText().toString();
        boolean isUp = up.isChecked();
        boolean isLow = low.isChecked();
        boolean isSym = sym.isChecked();
        boolean isNum = nums.isChecked();
        boolean isCopy = copy.isChecked();
        int saveLen = Integer.parseInt(length.getText().toString());
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVED_PASS, savePass);
        editor.putBoolean(SAVED_UP, isUp);
        editor.putBoolean(SAVED_LOW, isLow);
        editor.putBoolean(SAVED_SYM, isSym);
        editor.putBoolean(SAVED_NUM, isNum);
        editor.putBoolean(SAVED_COPY, isCopy);
        editor.putInt(SAVED_LEN, saveLen);
        editor.apply();
    }
    void load(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String genB = sharedPreferences.getString(SAVED_PASS, "");
        boolean upB = sharedPreferences.getBoolean(SAVED_UP, true);
        boolean lowB = sharedPreferences.getBoolean(SAVED_LOW, true);
        boolean symB = sharedPreferences.getBoolean(SAVED_SYM, true);
        boolean numB = sharedPreferences.getBoolean(SAVED_NUM, true);
        boolean copyB = sharedPreferences.getBoolean(SAVED_COPY, true);
        int lenB = sharedPreferences.getInt(SAVED_LEN, 6);
        etGen.setText(genB);
        up.setChecked(upB);
        low.setChecked(lowB);
        sym.setChecked(symB);
        nums.setChecked(numB);
        copy.setChecked(copyB);
        length.setText(""+lenB);
    }
}