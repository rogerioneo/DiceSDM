package br.edu.ifsp.scl.sdm.dicesdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Random usado para simular o lançamento do dado
    private Random geradorRandomico;
    // Componentes visuais
    private TextView resultadoTextView;
    private Button jogarDadoButton;

    private ImageView resultadoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geradorRandomico = new Random(System.currentTimeMillis());

        // Recuperando referência para o resultadoTextView do arquivo de layout
        resultadoTextView = findViewById(R.id.resultadoTextView);

        // Recuperando referência para o jogarDadoButton do arquivo de layout
        jogarDadoButton = findViewById(R.id.jogarDadoButton);
        jogarDadoButton.setOnClickListener(this);

        resultadoImageView = findViewById(R.id.resultadoImageView);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.jogarDadoButton) {
            int resultado = geradorRandomico.nextInt(6) + 1;
            resultadoTextView.setText(getString(R.string.face_sorteada) + resultado);
            setImageResource(resultadoImageView, resultado);
        }
    }

    private void setImageResource(ImageView iv, int face) {
        //Melhoria sugerida, ao invés de usar case
        String nomeRes = "dice_" + face;
        int idRes = getResources().getIdentifier(nomeRes,
                "drawable",
                getPackageName());
        iv.setImageResource(idRes);
    }

}
