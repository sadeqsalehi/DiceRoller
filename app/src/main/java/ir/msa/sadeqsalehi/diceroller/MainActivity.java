package ir.msa.sadeqsalehi.diceroller;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgdiceHolder1, imgdiceHolder2;
    Button btnRollDice;
    int[] dices = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    ConstraintLayout constraintLayout;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgdiceHolder1 = findViewById(R.id.imgDiceHolder1);
        imgdiceHolder2 = findViewById(R.id.imgDiceHolder2);
        constraintLayout = findViewById(R.id.constraintLayout);

    }

    public void RollDice_Click(View view) {
        final String TAG = "DiceActivity";
        int r1 = (int) (Math.random() * 6);
        int r2 = (int) (Math.random() * 6);
        imgdiceHolder1.setImageResource(dices[r1]);
        imgdiceHolder2.setImageResource(dices[r2]);
        Log.d(TAG, String.valueOf(r1));
        Log.d(TAG, String.valueOf(r2));

    }

    public void ShowSnackBar(View view) {
        Snackbar snackbar = Snackbar.make(constraintLayout, "Simple Text Snack bar", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Action !", Toast.LENGTH_LONG).show();
                    }
                });
        snackbar.setActionTextColor(Color.rgb(0, 130, 120));
        View sbview = snackbar.getView();
        TextView sbtext = sbview.findViewById(android.support.design.R.id.snackbar_text);
        TextView sbview2 = sbview.findViewById(android.support.design.R.id.snackbar_action);

        sbtext.setTextColor(Color.YELLOW);
        sbview2.setTextColor(Color.GREEN);
        snackbar.show();

    }
}
