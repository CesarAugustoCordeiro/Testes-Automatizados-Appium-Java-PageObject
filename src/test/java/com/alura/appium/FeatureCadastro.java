package com.alura.appium;

import static org.junit.Assert.assertTrue;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;


public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_senhas_diferentes() {

        AppiumDriver driver = AppiumDriveConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrparaTelaCadastro();

        telaCadastro.BuscarElementos();
        telaCadastro.PreencherFormulario("Cesar Augusto", "123", "1234");
        telaCadastro.Cadastrar();

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());

        driver.navigate().back();

    }

    @Test
    public void cadastrar_usuario() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriveConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrparaTelaCadastro();

        telaCadastro.BuscarElementos();
        telaCadastro.PreencherFormulario("Cesar Augusto", "1234", "1234");
        telaLogin = telaCadastro.Cadastrar();
        telaLogin.BuscarElementos();

    }
}
