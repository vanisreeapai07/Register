package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1,tv2;
    Button b1,b2;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
         b1 = findViewById(R.id.b1);
         b2 = findViewById(R.id.b2);
        realm = Realm.getDefaultInstance();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Display.class));
            }
        });

       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = et1.getText().toString();
                String s2 = et2.getText().toString();
                String s3 = tv1.getText().toString(); String s4 = tv2.getText().toString();
              if(TextUtils.isEmpty(s1)){      et1.setError("Mark attendance"); return;
            }
               if(TextUtils.isEmpty(s2)){ et2.setError("Mark attendance"); return;
                }

           DataModel model = new DataModel();
           Number id = realm.where(DataModel.class).max("id");
           long newid;
           if(id == null){ newid = 1;
            }else{ newid = id.intValue()+1;
            } model.setId(newid); model.setAttendance1(s1); model.setAttendance2(s2);

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealm(model);
                }
            });

                Toast.makeText(MainActivity.this, "Attendance saved",Toast.LENGTH_SHORT).show();

}
});
}

}
