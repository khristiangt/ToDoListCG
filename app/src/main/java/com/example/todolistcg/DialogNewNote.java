package com.example.todolistcg;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DialogNewNote extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_new_note,null);

        final EditText editTitle = dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = dialogView.findViewById(R.id.editDescription);

        final CheckBox checkBoxidea = dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = dialogView.findViewById(R.id.checkBoxImportant);

        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);
        Button buttonOk = dialogView.findViewById(R.id.buttonOk);


        builder.setView(dialogView)
                .setMessage("Añadir una nueva nota y comprobando que funciona nuestro controladorr de versiones");

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos una nota vacía
                Note newNote = new Note();

                //Configuramos las 5 variables de la nota creada

                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxidea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());


                //Hago un casting a Main Activity, que es quien ha llamado al dialogo
                MainActivity callingActivity = (MainActivity)getActivity();
                //Notificaremos a la Main Activity que hemos creado una nueva nota

                callingActivity.createNewNote(newNote);
                dismiss(); //Metodo para cerrar el dialogo, esto cierra el dialogo, porque ya se los pasamos a la MainActivity

            }
        });


        //Una vez configurada nuestra alerta, le indicamos al builder que debe crearla en pantalla
        return builder.create();
    }
}
