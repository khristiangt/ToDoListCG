package com.example.todolistcg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Note mTempNote = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos una nueva instancia de Dialog Show Note para mostrar el dialogo
                DialogShowNote dialog = new DialogShowNote();
                //Indico al dialogo que nota es la que debe mostar por pantalla
                dialog.sendNoteSelected(mTempNote);
                //Mostramos el dialogo por pantalla,lo invocamos a que se manifieste a través de un manager (FragmentManager)
                dialog.show(getSupportFragmentManager(),"note_show");

            }
        });




    }


    public void createNewNote (Note newNote){
        //Este método recibirá una nueva nota creada por el dialogo pertinente...
        mTempNote = newNote;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.actio_add){
            //Aqui debemos invocar una nueva instancia del dialogo para crear notas
            DialogNewNote dialog = new DialogNewNote();
            //MOstramos ese dialogo a través del manager
            dialog.show(getSupportFragmentManager(),"note_create");

        }

        return false;
    }
}
