package dev.omy.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.omy.applistacurso.R;
import dev.omy.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    EditText editText_nome;
    EditText editText_sobreNome;
    EditText editText_cursoDesejado;
    EditText editText_telContato;

    Button btn_limpar;
    Button btn_salvar;
    Button btn_finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        editText_nome = findViewById(R.id.editText_nome);
        editText_sobreNome = findViewById((R.id.editText_sobreNome));
        editText_cursoDesejado = findViewById(R.id.editText_cursoDesejado);
        editText_telContato = findViewById(R.id.editText_telContato);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);

        editText_nome.setText(pessoa.getPrimeiroNome());
        editText_sobreNome.setText(pessoa.getSobreNome());
        editText_cursoDesejado.setText(pessoa.getCursoDesejado());
        editText_telContato.setText(pessoa.getTelContato());

    }
}