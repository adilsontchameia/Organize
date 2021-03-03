package com.adilsonchameia.organize.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adilsonchameia.organize.R;
import com.adilsonchameia.organize.config.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //TelaCheia
        setFullscreen(true);
        //autoplay(4500,INFINITE);

        //Ocultar botoes
        setButtonBackVisible(false);
        setButtonNextVisible(false);
        //Slides
        sliders();

    }

    //Verificar se o usuario esta logado
    @Override
    protected void onStart() {
        super.onStart();
        //Verificar se o usuario esta logado
        verificarUsuarioLogado();
    }

    private void sliders() {
        //Sliders
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro4)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .canGoBackward(true)
                .build()
        );
    }

    public void btnEntrar(View view) {
        startActivity(new Intent(this, Login.class));
    }

    public void btnCadastrar(View view) {
        startActivity(new Intent(this, Cadastro.class));
    }

    public void verificarUsuarioLogado() {
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if (autenticacao.getCurrentUser() != null) {
            abrirTelaPrincipal();
        }
    }

    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, Principal.class));
    }

}