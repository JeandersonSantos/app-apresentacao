package com.example.jeanderson.appapresentacao;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //O código abaixo serve para configurar o meu ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icone2);
        getSupportActionBar().setTitle("App Apresentação.");
        getSupportActionBar().setSubtitle("Sempre aprendendo mais!");
    }

    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        onMenuOpened(Window.FEATURE_ACTION_BAR, menu);//mostrar o icone no menu cascata
        return super.onCreateOptionsMenu(menu);
    }
    //Este código serve para mostrar os icone no menu cascata
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if(featureId == Window.FEATURE_ACTION_BAR && menu != null){
            if(menu.getClass().getSimpleName().equals("MenuBuilder")){
                try{
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch(NoSuchMethodException e){
                } catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }

        return super.onMenuOpened(featureId, menu);
    }

    //AÇÕES MENU
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        String texto1,texto2,texto3,texto4,texto5,texto6;
        switch (item.getItemId()) {
            case R.id.compartilhar:
                //Ação de compartilhamento
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "Linck deste projeto no Github");//Titulo
                share.putExtra(Intent.EXTRA_TEXT, "https://github.com/JeandersonSantos/app-apresentacao");//Linck do meu app
                startActivity(Intent.createChooser(share, "Compartilhar!"));
                return true;
            case R.id.informacaoes:

                texto1 = "<html><body>"
                        + "<p align=\"justify\">"
                        + "Aplicação desenvolvida por: Jeanderson dos Santos"
                        + "</p>"
                        + "<p align=\"justify\">"
                        + "Contato: jeandersonsantospaz@gmail.com"
                        + "</p>"
                        + "</body></html>";

                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                dialogBuilder.setTitle("Informações");
                dialogBuilder.setIcon(R.mipmap.informacoes);

                LayoutInflater inflater = this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog, null);
                dialogBuilder.setView(dialogView);

                LinearLayout layoutConteudo = (LinearLayout) dialogView.findViewById(R.id.layoutConteudo);

                TextView text1 = new TextView(this);
                text1.setTextColor(Color.parseColor("#000000"));
                text1.setTextSize(17);
                text1.setTypeface(null, Typeface.BOLD);
                text1.setId(R.id.reservedNamedId2);
                text1.setText("Simulado Detran-CE");
                layoutConteudo.addView(text1);


                WebView webView1 = new WebView(this);
                webView1.setId(R.id.reservedNamedId3);
                webView1.loadData(texto1, "text/html", "iso-8859-1");
                webView1.setBackgroundColor(Color.TRANSPARENT);
                layoutConteudo.addView(webView1);


                final AlertDialog alertDialog = dialogBuilder.create();
                //Configurar posição no Layout
                LinearLayout.LayoutParams parametro = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                parametro.weight = 1.0f;
                parametro.gravity = Gravity.RIGHT;

                ImageView ImgFechar  = new ImageView(this);
                ImgFechar.setLayoutParams(parametro);//Posição
                ImgFechar.setId(R.id.reservedNamedId);
                ImgFechar.setImageResource(R.mipmap.fechar);
                layoutConteudo.addView(ImgFechar);
                ImgFechar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();

                return true;

            case R.id.duvidas:
                texto1 = "<html><body>"
                        + "<p align=\"justify\">"
                        + "Este app foi desenvolvido para apresentar o meu conhecimento e interesse sobre o desenvolvimento mobile."
                        + "</p>"
                        + "</body></html>";
                texto2 = "<html><body>"
                        + "<p align=\"justify\">"
                        + "Demostra a aplicação de um bloco de notas."
                        + "</p>"
                        + "</body></html>";
                texto3 = "<html><body>"
                        + "<p align=\"justify\">"
                        + "Demostra aplicação de uma calculadora."
                        + "</p>"
                        + "</body></html>";
                texto4 = "<html><body>"
                        + "<p align=\"justify\">"
                        + "Demostra a aplicação de uma QUIZ."
                        + "</p>"
                        + "</body></html>";

                final AlertDialog.Builder dialogBuilderD = new AlertDialog.Builder(this);
                dialogBuilderD.setTitle("Dúvidas");
                dialogBuilderD.setIcon(R.mipmap.duvidas);

                LayoutInflater inflaterd = this.getLayoutInflater();
                final View dialogViewD = inflaterd.inflate(R.layout.dialog, null);
                dialogBuilderD.setView(dialogViewD);

                LinearLayout layoutConteudoD = (LinearLayout) dialogViewD.findViewById(R.id.layoutConteudo);

                TextView text1d = new TextView(this);
                text1d.setTextColor(Color.parseColor("#000000"));
                text1d.setTextSize(17);
                text1d.setTypeface(null, Typeface.BOLD);
                text1d.setId(R.id.reservedNamedId2);
                text1d.setText("Apresentação:");
                layoutConteudoD.addView(text1d);


                WebView webView1d = new WebView(this);
                webView1d.setId(R.id.reservedNamedId3);
                webView1d.loadData(texto1, "text/html", "iso-8859-1");
                webView1d.setBackgroundColor(Color.TRANSPARENT);
                layoutConteudoD.addView(webView1d);

                TextView text2d = new TextView(this);
                text2d.setTextColor(Color.parseColor("#000000"));
                text2d.setTextSize(17);
                text2d.setTypeface(null, Typeface.BOLD);
                text2d.setId(R.id.reservedNamedId4);
                text2d.setText("Primeiro botão:");
                layoutConteudoD.addView(text2d);

                WebView webView2d = new WebView(this);
                webView2d.setId(R.id.reservedNamedId5);
                webView2d.loadData(texto2, "text/html", "iso-8859-1");
                webView2d.setBackgroundColor(Color.TRANSPARENT);
                layoutConteudoD.addView(webView2d);

                TextView text3d = new TextView(this);
                text3d.setTextColor(Color.parseColor("#000000"));
                text3d.setTextSize(17);
                text3d.setTypeface(null, Typeface.BOLD);
                text3d.setId(R.id.reservedNamedId6);
                text3d.setText("Segundo botão:");
                layoutConteudoD.addView(text3d);

                WebView webView3d = new WebView(this);
                webView3d.setId(R.id.reservedNamedId7);
                webView3d.loadData(texto3, "text/html", "iso-8859-1");
                webView3d.setBackgroundColor(Color.TRANSPARENT);
                layoutConteudoD.addView(webView3d);

                TextView text4d = new TextView(this);
                text4d.setTextColor(Color.parseColor("#000000"));
                text4d.setTextSize(17);
                text4d.setTypeface(null, Typeface.BOLD);
                text4d.setId(R.id.reservedNamedId8);
                text4d.setText("Terceiro botão:");
                layoutConteudoD.addView(text4d);

                WebView webView4d = new WebView(this);
                webView4d.setId(R.id.reservedNamedId9);
                webView4d.loadData(texto4, "text/html", "iso-8859-1");
                webView4d.setBackgroundColor(Color.TRANSPARENT);
                layoutConteudoD.addView(webView4d);


                final AlertDialog alertDialogD = dialogBuilderD.create();

                //Configurar posição no Layout
                LinearLayout.LayoutParams paramet = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                paramet.weight = 1.0f;
                paramet.gravity = Gravity.RIGHT;

                //ImageView ImgFechar  = (ImageView) dialogView.findViewById(R.id.imgFechar);
                ImageView ImgFecharD  = new ImageView(this);
                ImgFecharD.setLayoutParams(paramet);//Posição
                ImgFecharD.setId(R.id.reservedNamedId);
                ImgFecharD.setImageResource(R.mipmap.fechar);
                layoutConteudoD.addView(ImgFecharD);
                ImgFecharD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogD.dismiss();
                    }
                });
                alertDialogD.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
