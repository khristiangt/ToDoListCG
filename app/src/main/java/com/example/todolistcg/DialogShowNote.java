package com.example.todolistcg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogShowNote extends AppCompatDialogFragment {

    private Note mNote;

    public void sendNoteSelected(Note noteSelected){
        this.mNote = noteSelected;


    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_show_note,null); //NO lo empalme ni una actividad conocidad si no que lo ponga arriba deltodo como una aletrta

        TextView txtTitle = dialogView.findViewById(R.id.textViewTitle);
        TextView txtDescription = dialogView.findViewById(R.id.textViewDescription);
        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        ImageView ivImportant = dialogView.findViewById(R.id.imageViewImportant);
        ImageView ivTodo = dialogView.findViewById(R.id.imageViewTodo);
        ImageView ivIdea = dialogView.findViewById(R.id.imageViewIdea);

        //Cada imagen se oculta si la nota no es de ese tipo
        if (!mNote.isImportant()){
            ivImportant.setVisibility(View.GONE);

        }
        if (!mNote.isTodo()){
            ivTodo.setVisibility(View.GONE);
        }
        if (!mNote.isIdea()){
            ivIdea.setVisibility(View.GONE);
        }


        Button btnOk = dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView)
                .setMessage("Tu nota: ");

        //El boton ok simplemente cierra la nota
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); //cierra la nota
            }
        });









        return builder.create(); //para crear diractemente esa alerta en pantalla
    }
}
