package com.example.meserosapp.ui.pago;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.producto.CantidadProductoDialogActivity;
import com.example.meserosapp.ui.producto.ProductoActivity;

public class DialogPagoActivity extends AppCompatDialogFragment {

    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
  //  private PagoViewModel pagoViewModel;
    private TextView detallePintar;
  private DialogPagoActivity.DialogPagoListener listener;
    private PagoActivity activity;

    public DialogPagoActivity(PagoActivity pagoActivity){
        this.activity = pagoActivity;
    }


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
                     //  String detallesPintados = detallePintar.setText();

                       activity.sendHttp();




                    }
                });

    //    configShared = getSharedPreferences("configShared", Context.MODE_PRIVATE);
    //    editorConfig = configShared.edit();
        detallePintar = view.findViewById(R.id.detalleTxt);
        return builder.create();
    }

    public interface DialogPagoListener{

    }
}




//    Intent intent = getIntent();
//    String val = intent.getStringExtra("detalle");
// TextView textView= (TextView) findViewById(R.id.DialogDetailId);
//textView.setText(val);