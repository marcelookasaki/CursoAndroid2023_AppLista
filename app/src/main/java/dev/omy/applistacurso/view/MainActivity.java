package dev.omy.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.omy.applistacurso.R;
import dev.omy.applistacurso.controller.PessoaController;

import dev.omy.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController pessoaController;

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

        pessoaController = new PessoaController(MainActivity.this);
        pessoaController.toString();
        pessoaController.buscar(pessoa);

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


        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_nome.setText("");
                editText_sobreNome.setText("");
                editText_cursoDesejado.setText("");
                editText_telContato.setText("");

                pessoaController.limpar();
            }
        });

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre!!!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editText_nome.getText().toString());
                pessoa.setSobreNome(editText_sobreNome.getText().toString());
                pessoa.setCursoDesejado(editText_cursoDesejado.getText().toString());
                pessoa.setTelContato(editText_telContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

                pessoaController.salvar(pessoa);

            }
        });

    }
}