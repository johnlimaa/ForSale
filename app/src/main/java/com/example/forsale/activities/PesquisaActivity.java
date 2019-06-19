package com.example.forsale.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forsale.R;
import com.example.forsale.access.Produto;
import com.example.forsale.access.ProdutoDAO;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private ListView list;
    private Button btn_back;

    private ProdutoDAO dao;
    private ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

            dao = new ProdutoDAO(this);
            list = findViewById(R.id.listaDeBusca);
            btn_back = findViewById(R.id.buttonVoltar);
            Intent busca_intent = getIntent();

            if(busca_intent != null) {
                try {
                    produtos = dao.obterTodos(busca_intent.getStringExtra("busca"));


                    int img[] = {R.drawable.lenovo, R.drawable.samsung, R.drawable.dell, R.drawable.sony};
                    String title[] = {produtos.get(0).getNome(), produtos.get(1).getNome(), produtos.get(2).getNome(), produtos.get(3).getNome()};
                    String desc[] = {produtos.get(0).getDescricao(), produtos.get(1).getDescricao(), produtos.get(2).getDescricao(), produtos.get(3).getDescricao()};
                    Float val[] = {produtos.get(0).getValor(), produtos.get(1).getValor(), produtos.get(2).getValor(), produtos.get(3).getValor()};

                    //ArrayAdapter<Produto> adaptador = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
                    MyAdapter adaptador = new MyAdapter(this, title, desc, val, img);
                    list.setAdapter(adaptador);
                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    call_back();
                }
            });

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    try {
                    TextView nome;
                    TextView desc;
                    TextView val;
                    int img[] = {R.drawable.lenovo, R.drawable.samsung, R.drawable.dell, R.drawable.sony};
                    if (position == 0) {
                        nome = view.findViewById(R.id.prod_nome);
                        desc = view.findViewById(R.id.prod_desc);
                        val = view.findViewById(R.id.prod_val);

                        call_preview(nome.getText().toString(), desc.getText().toString(), val.getText().toString(), img[0]);
                    }
                    if (position == 1) {
                        nome = view.findViewById(R.id.prod_nome);
                        desc = view.findViewById(R.id.prod_desc);
                        val = view.findViewById(R.id.prod_val);

                        call_preview(nome.getText().toString(), desc.getText().toString(), val.getText().toString(), img[1]);

                    }
                    if (position == 2) {
                        nome = view.findViewById(R.id.prod_nome);
                        desc = view.findViewById(R.id.prod_desc);
                        val = view.findViewById(R.id.prod_val);

                        call_preview(nome.getText().toString(), desc.getText().toString(), val.getText().toString(), img[2]);
                    }
                    if (position == 3) {
                        nome = view.findViewById(R.id.prod_nome);
                        desc = view.findViewById(R.id.prod_desc);
                        val = view.findViewById(R.id.prod_val);

                        call_preview(nome.getText().toString(), desc.getText().toString(), val.getText().toString(), img[3]);
                    }
                    } catch (Exception e) {
                        Toast.makeText(PesquisaActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String adTitle[];
        String adDesc[];
        Float adVal[];
        int adImg[];

        public MyAdapter(Context c, String title[], String desc[], Float val[], int images[]) {
            super(c, R.layout.list_item, R.id.prod_nome, title);
            this.context = c;
            this.adTitle = title;
            this.adDesc = desc;
            this.adVal = val;
            this.adImg = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View converView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.list_item, parent, false);
            ImageView images = row.findViewById(R.id.prod_logo);
            TextView title = row.findViewById(R.id.prod_nome);
            TextView desc = row.findViewById(R.id.prod_desc);
            TextView val = row.findViewById(R.id.prod_val);

            images.setImageResource(adImg[position]);
            title.setText(adTitle[position]);
            desc.setText(adDesc[position]);
            val.setText(String.valueOf(adVal[position]));

            return row;
        }
    }

    public void call_back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void call_preview(String title, String desc, String val, int img) {
        Intent intent = new Intent(this, PreviewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        intent.putExtra("val", val);
        intent.putExtra("img", img);
        startActivity(intent);
    }
}
