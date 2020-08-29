package com.example.meserosapp.ui.pago;

import android.app.Dialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.meserosapp.R;

public class DialogPagoActivity extends AppCompatDialogFragment {

  //  private PagoViewModel pagoViewModel;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_pago, null);
        /*pagoViewModel = new ViewModelProvider(this).get(PagoViewModel.class);
        pagoViewModel.eliminarPedido();
        observableViewModel();
*/


        builder.setView(view)
                .setTitle("Detalle Pago")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     //   observableViewModel();

                    }
                });

        return builder.create();
    }

  /*  private void observableViewModel() {
        pagoViewModel.getPedidoE().observe(this, pedido -> {
            if (pedido != null) {



            }
        });

        pagoViewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(getActivity(), error.getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });
    }
*/

}




//    Intent intent = getIntent();
//    String val = intent.getStringExtra("detalle");
// TextView textView= (TextView) findViewById(R.id.DialogDetailId);
//textView.setText(val);