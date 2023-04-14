package hcmute.edu.vn.firebase_insert_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    AppCompatEditText textName, textPhone, textAge, textHeight;
    AppCompatButton btn;
    DatabaseReference dtb;

    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.Name);
        textAge = findViewById(R.id.Age);
        textPhone = findViewById(R.id.Phone);
        textHeight = findViewById(R.id.height);
        btn = findViewById(R.id.save_btn);
        member = new Member();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dtb = database.getReference().child("Member");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(textAge.getText().toString().trim());
                Float height = Float.parseFloat(textHeight.getText().toString().trim());
                Long phone = Long.parseLong(textPhone.getText().toString().trim());
                member.setName(textName.getText().toString().trim());
                member.setAge(age);
                member.setPhone(phone);
                member.setHeight(height);
                dtb.child("member1").setValue(member);
                Toast.makeText(MainActivity.this,"data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void playMP3(View v){
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/test-firebase-b3a5d.appspot.com/o/%C4%90%C3%B4i_L%E1%BB%9Di_Ho%C3%A0ng_D%C5%A9ng_Official_Lyrics_Video_.mp3?alt=media&token=849ae8da-3f08-4efb-a0c6-a5fc92046bcb");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
            {
                @Override
                public void onPrepared(MediaPlayer mp)
                {
                    mp.start();
                }
            });
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}