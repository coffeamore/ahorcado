/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    private String palabra;
    private char letra;
    private int numErrores;
    private int numAciertos;
    private Icon icono3;
    private Icon icono4;
    private Icon icono5;
    private Icon icono6;
    private Icon icono7;
    private Icon icono8;
    private Icon icono9;
    private JButton[] botones;
    
    /**
     * VentanaPrincipal
     * Constructor de la clase, se da valores a los atributos
     */
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        escogerPalabra();
        numErrores = 0;
        numAciertos = 0;
        iniciarCajaTexto();
        botones = new JButton[27];
        agregarBotones();
        darPista();
        generarImagenes();
        cambiarImagen();
    }
    
    /**
     * agregarBotones
     * agrega los botones en el vector
     */
    private void agregarBotones(){
        botones[0] = jButton1;
        botones[1] = jButton2;
        botones[2] = jButton3;
        botones[3] = jButton4;
        botones[4] = jButton5;
        botones[5] = jButton6;
        botones[6] = jButton7;
        botones[7] = jButton8;
        botones[8] = jButton9;
        botones[9] = jButton10;
        botones[10] = jButton11;
        botones[11] = jButton12;
        botones[12] = jButton13;
        botones[13] = jButton14;
        botones[14] = jButton15;
        botones[15] = jButton16;
        botones[16] = jButton17;
        botones[17] = jButton18;
        botones[18] = jButton19;
        botones[19] = jButton20;
        botones[20] = jButton21;
        botones[21] = jButton22;
        botones[22] = jButton23;
        botones[23] = jButton24;
        botones[24] = jButton25;
        botones[25] = jButton26;
        botones[26] = jButton27;
    }
    
    /**
     * generarImagenes
     * metodo para asignar a los iconos las imagenes correspondientes.
     */
    private void generarImagenes(){
        
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/silueta/3.png"));
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("/silueta/4.png"));
        ImageIcon imagen5 = new ImageIcon(getClass().getResource("/silueta/5.png"));
        ImageIcon imagen6 = new ImageIcon(getClass().getResource("/silueta/6.png"));
        ImageIcon imagen7 = new ImageIcon(getClass().getResource("/silueta/7.png"));
        ImageIcon imagen8 = new ImageIcon(getClass().getResource("/silueta/8.png"));
        ImageIcon imagen9 = new ImageIcon(getClass().getResource("/silueta/9.png"));
        icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono4 = new ImageIcon(imagen4.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono5 = new ImageIcon(imagen5.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono6 = new ImageIcon(imagen6.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono7 = new ImageIcon(imagen7.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono8 = new ImageIcon(imagen8.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        icono9 = new ImageIcon(imagen9.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
    }
    
    /**
     * iniciarCajaTexto
     * inicia la caja de texto con guiones bajos dependiendo de la cantidad de letras
     */
    private void iniciarCajaTexto(){
        
        txtPalabra.setText("");
        for(int i = 0; i < palabra.length(); i++){
            txtPalabra.setText(txtPalabra.getText() + "   _");
        }
        
    }

    /**
     * escogerPalabra
     * escoge una palabra del Map al azar
     */
    private void escogerPalabra(){
        
        Map<String, String> palabras = new HashMap<>();
        palabras.put("S.O. Libre", "WINDOWS");
        palabras.put("Editor de fotografias", "PHOTOSHOP");
        palabras.put("IA famosa", "CHATGPT");
        palabras.put("Linux boliviano", "PLURIOS");
        palabras.put("Herramienta", "TALADRO");
        palabras.put("Marca de bebida", "PEPSI");
        palabras.put("Marca de auto", "MITSUBISHI");
        palabras.put("Marca de celular", "HUAWEI");
        palabras.put("País de Europa", "ALEMANIA");
        palabras.put("Objeto", "MOCHILA");
        String[] claves = {"S.O. Libre", "Editor de fotografias", "IA famosa", "Linux boliviano", "Herramienta", "Marca de bebida", "Marca de auto", "Marca de celular", "País de Europa", "Objeto"}; 
        String clave = claves[(int)(Math.random()*claves.length)];
        palabra = palabras.get(clave);
        lblPista.setText("Pista : " + clave);
        
    }
    
    /**
     * darPista
     * escoge una letra aleatoria, y muestra su o sus ubicaciones en la palabra
     */
    private void darPista(){
        
        int numAleatorio = (int)(Math.random()*palabra.length());
        letra = palabra.charAt(numAleatorio);
        verificarLetra();
        
        for(int i = 0; i < botones.length; i++){
            if(botones[i].getText().charAt(0) == letra){
                botones[i].setEnabled(false);
            }
        }
        
    }
    
    /**
     * cambiarImagen
     * cambia la imagen cuando el usuario se equivoca
     */
    private void cambiarImagen(){
        
        switch(numErrores){
            case 6:
                lblImagen.setIcon(icono9);
                break;
            case 5:
                lblImagen.setIcon(icono8);
                break;
            case 4:
                lblImagen.setIcon(icono7);
                break;
            case 3:
                lblImagen.setIcon(icono6);
                break;
            case 2:
                lblImagen.setIcon(icono5);
                break;
            case 1:
                lblImagen.setIcon(icono4);
                break;
            case 0:
                lblImagen.setIcon(icono3);
                break;
        }
        
    }

    /**
     * reemplazarLetra
     * metodo que ayuda para encontrar la letra seleccionada por el usuario
     */
    private String reemplazarLetra(String texto, int indiceLetraReemplazada, char nuevaLetra){
        //Modificamos el índice dependiendo de lo que necesiitamos. Sino solo omitimos.
        indiceLetraReemplazada = 3 + indiceLetraReemplazada * 4;
        texto = texto.substring(0, indiceLetraReemplazada) + Character.toString(nuevaLetra) + texto.substring(indiceLetraReemplazada + 1);
        return texto;
        
    }
    
    /**
     * mostrarPalabra
     * una vez que el usuario pierde, se muestra la palabra en la caja de texto
     */
    private void mostrarPalabra(){
        for(int i = 0; i < palabra.length(); i++){
            String temp = txtPalabra.getText();
            temp = reemplazarLetra(temp, i, palabra.charAt(i));
            txtPalabra.setText(temp);
        }
    }
    
    /**
     * verificarLetra
     * Verifica si la letra está o no en la palabra
     */
    private void verificarLetra(){
        
        boolean letraEncontrada = false;
        
        for(int i = 0; i < palabra.length(); i++){
            if(letra == palabra.charAt(i)){
                letraEncontrada = true;
                String temp = txtPalabra.getText();
                temp = reemplazarLetra(temp, i, letra);
                txtPalabra.setText(temp);
                numAciertos++;
            }
        }
        if(letraEncontrada == false){
            numErrores++;
            cambiarImagen();
        }
        
        if(numErrores == 6){
            desabilitarBotones();
            mostrarPalabra();
            JOptionPane.showMessageDialog(null, "¡Ahorcado!");
        }
        
        if(numAciertos == palabra.length()){
            desabilitarBotones();
            JOptionPane.showMessageDialog(null, "¡Ganaste!");
        }
    }
    
    /**
     * desabilitarBotones
     * Desabilita botones cuando el usuario pierde o gana
     */
    private void desabilitarBotones(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
        jButton11.setEnabled(false);
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
        jButton14.setEnabled(false);
        jButton15.setEnabled(false);
        jButton16.setEnabled(false);
        jButton17.setEnabled(false);
        jButton18.setEnabled(false);
        jButton19.setEnabled(false);
        jButton20.setEnabled(false);
        jButton21.setEnabled(false);
        jButton22.setEnabled(false);
        jButton23.setEnabled(false);
        jButton24.setEnabled(false);
        jButton25.setEnabled(false);
        jButton26.setEnabled(false);
        jButton27.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPalabra = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        lblPista = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AHORCADO");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPalabra.setEditable(false);
        txtPalabra.setBackground(new java.awt.Color(102, 0, 0));
        txtPalabra.setFont(new java.awt.Font("Kristen ITC", 0, 14)); // NOI18N
        txtPalabra.setForeground(new java.awt.Color(255, 255, 255));
        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPalabra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 387, 50));

        lblImagen.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 349, 399));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton2.setText("A");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 53, 52));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton1.setText("B");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 53, 52));

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton3.setText("C");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 53, 52));

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton4.setText("D");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 53, 52));

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton5.setText("E");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 53, 52));

        jButton6.setBackground(new java.awt.Color(204, 255, 204));
        jButton6.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton6.setText("F");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 53, 52));

        jButton7.setBackground(new java.awt.Color(204, 255, 204));
        jButton7.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton7.setText("G");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 53, 52));

        jButton8.setBackground(new java.awt.Color(204, 255, 204));
        jButton8.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton8.setText("H");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 53, 52));

        jButton9.setBackground(new java.awt.Color(204, 255, 204));
        jButton9.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton9.setText("I");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 53, 52));

        jButton10.setBackground(new java.awt.Color(204, 255, 204));
        jButton10.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton10.setText("J");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 53, 52));

        jButton11.setBackground(new java.awt.Color(204, 255, 204));
        jButton11.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton11.setText("K");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 53, 52));

        jButton12.setBackground(new java.awt.Color(204, 255, 204));
        jButton12.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton12.setText("L");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 53, 52));

        jButton13.setBackground(new java.awt.Color(204, 255, 204));
        jButton13.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton13.setText("M");
        jButton13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 53, 52));

        jButton14.setBackground(new java.awt.Color(204, 255, 204));
        jButton14.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton14.setText("N");
        jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 53, 52));

        jButton21.setBackground(new java.awt.Color(204, 255, 204));
        jButton21.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton21.setText("T");
        jButton21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 53, 52));

        jButton20.setBackground(new java.awt.Color(204, 255, 204));
        jButton20.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton20.setText("S");
        jButton20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 53, 52));

        jButton19.setBackground(new java.awt.Color(204, 255, 204));
        jButton19.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton19.setText("R");
        jButton19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 53, 52));

        jButton15.setBackground(new java.awt.Color(204, 255, 204));
        jButton15.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton15.setText("Ñ");
        jButton15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 53, 52));

        jButton16.setBackground(new java.awt.Color(204, 255, 204));
        jButton16.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton16.setText("O");
        jButton16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 53, 52));

        jButton17.setBackground(new java.awt.Color(204, 255, 204));
        jButton17.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton17.setText("P");
        jButton17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 53, 52));

        jButton18.setBackground(new java.awt.Color(204, 255, 204));
        jButton18.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton18.setText("Q");
        jButton18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 53, 52));

        jButton26.setBackground(new java.awt.Color(204, 255, 204));
        jButton26.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton26.setText("Y");
        jButton26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 53, 52));

        jButton27.setBackground(new java.awt.Color(204, 255, 204));
        jButton27.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton27.setText("Z");
        jButton27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 53, 52));

        jButton25.setBackground(new java.awt.Color(204, 255, 204));
        jButton25.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton25.setText("X");
        jButton25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 53, 52));

        jButton24.setBackground(new java.awt.Color(204, 255, 204));
        jButton24.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton24.setText("W");
        jButton24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 53, 52));

        jButton23.setBackground(new java.awt.Color(204, 255, 204));
        jButton23.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton23.setText("V");
        jButton23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 53, 52));

        jButton22.setBackground(new java.awt.Color(204, 255, 204));
        jButton22.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        jButton22.setText("U");
        jButton22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 53, 52));

        btnReiniciar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnReiniciar.setText("REINICIAR");
        btnReiniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 163, 43));

        jButton28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton28.setText("ATRAS");
        jButton28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 163, 43));

        lblPista.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        lblPista.setForeground(new java.awt.Color(255, 255, 255));
        lblPista.setText("Pista : ");
        jPanel1.add(lblPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 234, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        letra = jButton1.getText().charAt(0);
        verificarLetra();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        letra = jButton2.getText().charAt(0);
        verificarLetra();
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        letra = jButton3.getText().charAt(0);
        verificarLetra();
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        letra = jButton4.getText().charAt(0);
        verificarLetra();
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        letra = jButton5.getText().charAt(0);
        verificarLetra();
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        letra = jButton6.getText().charAt(0);
        verificarLetra();
        jButton6.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        letra = jButton7.getText().charAt(0);
        verificarLetra();
        jButton7.setEnabled(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        letra = jButton8.getText().charAt(0);
        verificarLetra();
        jButton8.setEnabled(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        letra = jButton9.getText().charAt(0);
        verificarLetra();
        jButton9.setEnabled(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        letra = jButton10.getText().charAt(0);
        verificarLetra();
        jButton10.setEnabled(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        letra = jButton11.getText().charAt(0);
        verificarLetra();
        jButton11.setEnabled(false);
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        letra = jButton12.getText().charAt(0);
        verificarLetra();
        jButton12.setEnabled(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        letra = jButton13.getText().charAt(0);
        verificarLetra();
        jButton13.setEnabled(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        letra = jButton14.getText().charAt(0);
        verificarLetra();
        jButton14.setEnabled(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        letra = jButton15.getText().charAt(0);
        verificarLetra();
        jButton15.setEnabled(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        letra = jButton16.getText().charAt(0);
        verificarLetra();
        jButton16.setEnabled(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        letra = jButton17.getText().charAt(0);
        verificarLetra();
        jButton17.setEnabled(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        letra = jButton18.getText().charAt(0);
        verificarLetra();
        jButton18.setEnabled(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        letra = jButton19.getText().charAt(0);
        verificarLetra();
        jButton19.setEnabled(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        letra = jButton20.getText().charAt(0);
        verificarLetra();
        jButton20.setEnabled(false);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        letra = jButton21.getText().charAt(0);
        verificarLetra();
        jButton21.setEnabled(false);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        letra = jButton22.getText().charAt(0);
        verificarLetra();
        jButton22.setEnabled(false);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        letra = jButton23.getText().charAt(0);
        verificarLetra();
        jButton23.setEnabled(false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        letra = jButton24.getText().charAt(0);
        verificarLetra();
        jButton24.setEnabled(false);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        letra = jButton25.getText().charAt(0);
        verificarLetra();
        jButton25.setEnabled(false);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        letra = jButton26.getText().charAt(0);
        verificarLetra();
        jButton26.setEnabled(false);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        letra = jButton27.getText().charAt(0);
        verificarLetra();
        jButton27.setEnabled(false);
    }//GEN-LAST:event_jButton27ActionPerformed

    /**
     * btnReiniciarActionPerformed
     * Evento de accion que reinicia el juego
     * @param evt evento de accion
     */
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        numErrores = 0;
        numAciertos = 0;
        cambiarImagen();
        escogerPalabra();
        iniciarCajaTexto();
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
        jButton12.setEnabled(true);
        jButton13.setEnabled(true);
        jButton14.setEnabled(true);
        jButton15.setEnabled(true);
        jButton16.setEnabled(true);
        jButton17.setEnabled(true);
        jButton18.setEnabled(true);
        jButton19.setEnabled(true);
        jButton20.setEnabled(true);
        jButton21.setEnabled(true);
        jButton22.setEnabled(true);
        jButton23.setEnabled(true);
        jButton24.setEnabled(true);
        jButton25.setEnabled(true);
        jButton26.setEnabled(true);
        jButton27.setEnabled(true);
        darPista();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        iniciar atras = new iniciar();
        atras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPista;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
