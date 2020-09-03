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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.producto.CantidadProductoDialogActivity;
import com.example.meserosapp.ui.producto.ProductoActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class DialogPagoActivity extends AppCompatDialogFragment {

    private Double totalPago;
    private JSONArray pedidos = new JSONArray();
    private SharedPreferences configShared;
    private SharedPreferences.Editor editorConfig;
  //  private PagoViewModel pagoViewModel;
    private TextView detallePintar;
    private LinearLayout linearPedido;
  private DialogPagoActivity.DialogPagoListener listener;
    private PagoActivity activity;

    public DialogPagoActivity(PagoActivity pagoActivity, JSONArray pedidos){
        this.activity = pagoActivity;
        this.pedidos= pedidos;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_pago, null);
        linearPedido = view.findViewById(R.id.detallesPedidoPago);
        totalPago=0.0;

        try{

            for(int i =0; i<pedidos.length(); i++){
                JSONObject pedido = pedidos.getJSONObject(i);
                System.out.println(pedido);

                LinearLayout nombre= new LinearLayout(getActivity());
                nombre.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout cantidad = new LinearLayout(getActivity());
                cantidad.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout valor = new LinearLayout(getActivity());
                valor.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout total = new LinearLayout(getActivity());
                total.setOrientation(LinearLayout.HORIZONTAL);

                TextView nombreA = new TextView(getActivity());
                nombreA.setText("Nombre: ");
                TextView nombreB = new TextView(getActivity());
                nombreB.setText(pedido.getString("nombre"));
                TextView cantidadA = new TextView(getActivity());
                cantidadA.setText("Cantidad: ");
                TextView cantidadB = new TextView(getActivity());
                cantidadB.setText(pedido.getString("cantidad"));
                TextView valorA = new TextView(getActivity());
                valorA.setText("Valor: ");
                TextView valorB = new TextView(getActivity());
                valorB.setText(pedido.getString("valor"));
                TextView totalA = new TextView(getActivity());
                totalA.setText("Total: ");
                TextView totalB = new TextView(getActivity());
                totalB.setText(pedido.getString("total"));

                nombre.addView(nombreA);
                nombre.addView(nombreB);
                cantidad.addView(cantidadA);
                cantidad.addView(cantidadB);
                valor.addView(valorA);
                valor.addView(valorB);
                total.addView(totalA);
                total.addView(totalB);
                total.setPadding(0,0,0,25);

                totalPago += Double.parseDouble(String.valueOf(Integer.parseInt(pedido.getString("cantidad"))*Double.parseDouble(pedido.getString("valor"))));
                //System.out.println("Total a pagar: "+totalPago);
                linearPedido.addView(nombre);
                linearPedido.addView(cantidad);
                linearPedido.addView(valor);
                linearPedido.addView(total);

            }
            LinearLayout pagoTotal = new LinearLayout(getActivity());
            pagoTotal.setOrientation(LinearLayout.HORIZONTAL);

            TextView pagoTotalA = new TextView(getActivity());
            pagoTotalA.setText("Pago Total: ");
            pagoTotalA.setTextSize(21);
            TextView pagoTotalB = new TextView(getActivity());
            pagoTotalB.setText(totalPago.toString());
            pagoTotalB.setTextSize(21);

            pagoTotal.addView(pagoTotalA);
            pagoTotal.addView(pagoTotalB);
            pagoTotal.setPadding(0,25,0,0);
            linearPedido.addView(pagoTotal);
            //detallePintar = view.findViewById(R.id.detalleTxt);
        }catch (Exception e){
            System.out.println(e);
        }
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


        return builder.create();
    }

    public interface DialogPagoListener{

    }
}




//    Intent intent = getIntent();
//    String val = intent.getStringExtra("detalle");
// TextView textView= (TextView) findViewById(R.id.DialogDetailId);
//textView.setText(val);