/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.ListaEncadeada;
import Model.MapaDispersao;
import Model.NoLista;
import Model.NoMapa;
import Model.Palavra;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenzi
 */
public class Tela extends javax.swing.JDialog {

    MapaDispersao<String, Palavra> mapa;

    /**
     * Creates new form Tela
     */
    public Tela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    //busca caso usuario informe 1 palavra apenas
    public void buscarPalavraUnica(String palavra) {
        Palavra palavraObj = mapa.buscar(palavra);
        
        if(palavraObj == null){
            jTA.append("palavra '" + palavra + "' nao encontrada!\n");
            return;
        }
        
        jTA.append("Arquivos encontrados para palavra '" + palavra +"':\n");
        
        ListaEncadeada<File> listaArquivos = palavraObj.getArquivos();
        NoLista<File> no = listaArquivos.getPrimeiro();
        while(no != null){
            jTA.append(" - " + no.getInfo().getAbsolutePath() + "\n");
            no = no.getProximo();
        }
    }
    
    //busca caso usuario informe 2 ou mais palavras
    private void buscarMultiplasPalavras(String[] palavras) {
        jTA.append("Buscando: " + String.join(", ", palavras) + "\n");

        ListaEncadeada<File> arquivosEmComun = obterArquivosDaPalavra(palavras[0]);

        if (arquivosEmComun.estaVazia()) {
            jTA.append("Palavra '" + palavras[0] + "' não encontrada.\n");
            return;
        }

        for (int i = 1; i < palavras.length; i++) {
            ListaEncadeada<File> arquivosDaPalavra = obterArquivosDaPalavra(palavras[i]);
            if (arquivosDaPalavra.estaVazia()) {
                jTA.append("Palavra '" + palavras[i] + "' nao encontrada.\n");
                return;
            }

            
            arquivosEmComun = filtrarArquivosComuns(arquivosEmComun, arquivosDaPalavra);
        }

        
        if (arquivosEmComun.estaVazia()) {
            jTA.append("Nenhum arquivo contem todas as palavras.\n");
        } else {
            NoLista<File> no = arquivosEmComun.getPrimeiro();
            while (no != null) {
                jTA.append(" - " + no.getInfo().getAbsolutePath() + "\n");
                no = no.getProximo();
            }
        }
    }

    //Obtem arquivos os arquivos contenham a palavra 
    private ListaEncadeada<File> obterArquivosDaPalavra(String palavra) {
        ListaEncadeada<File> arquivos = mapa.buscar(palavra).getArquivos();
        return arquivos;
    }
    
    //Cria uma lista de todos os arquivos que contenham todas as palavras da lista informada
    private ListaEncadeada<File> filtrarArquivosComuns(ListaEncadeada<File> lista1, ListaEncadeada<File> lista2) {
        ListaEncadeada<File> resultado = new ListaEncadeada<>();
        NoLista<File> no = lista1.getPrimeiro();

        while (no != null) {
            File arquivo = no.getInfo();
            if (contemArquivo(lista2, arquivo)) {
                resultado.inserir(arquivo);
            }
            no = no.getProximo();
        }

        return resultado;
    }

    //verifica se a lista informada já possui o arquivo informado
    private boolean contemArquivo(ListaEncadeada<File> lista, File arquivo) {
        if (lista == null || lista.estaVazia()) {
            return false;
        }

        NoLista<File> no = lista.getPrimeiro();
        while (no != null) {
            if (no.getInfo().equals(arquivo)) {
                return true;
            }
            no = no.getProximo();
        }
        return false;
    }
    
    public void lerArquivo(File file){
        //criar hashMap
        

        //Ler arquivos
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split("\\W+");

                for (String palavraNova : palavras) {
                    if ((palavraNova.length() >= 3) && (palavraNova.matches(".*[a-zA-Z].*"))) {
                        palavraNova = palavraNova.toLowerCase();
                        Palavra palavraMapa = mapa.buscar(palavraNova);
                        
                        if(palavraMapa !=  null){
                            palavraMapa.adicionarArquivo(file);
                        } else {
                            Palavra novaPalavraClasse = new Palavra(palavraNova, file);
                            mapa.inserir(palavraNova, novaPalavraClasse);
                        }
                    }
                }
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void explorarDiretorio(File caminho){
        File[] arquivos = caminho.listFiles();
        
        if(arquivos == null){
            return;
        }
        
        for(File arquivo : arquivos){
            if(arquivo.isDirectory()){
            explorarDiretorio(arquivo);
        } else {
                lerArquivo(arquivo);
            }
        }
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
        jBler = new javax.swing.JButton();
        jBlimpar = new javax.swing.JButton();
        jTFcaminho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFpalavras = new javax.swing.JTextField();
        jBpesquisar = new javax.swing.JButton();
        jBlimparPalavra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Caminho"));

        jBler.setText("Ler arquivos");
        jBler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlerActionPerformed(evt);
            }
        });

        jBlimpar.setText("Limpar");
        jBlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimparActionPerformed(evt);
            }
        });

        jLabel1.setText("Caminho: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBlimpar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFcaminho)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBlimpar)
                    .addComponent(jBler))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        jLabel2.setText("Palavras: ");

        jBpesquisar.setText("Pesquisar");
        jBpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpesquisarActionPerformed(evt);
            }
        });

        jBlimparPalavra.setText("Limpar");
        jBlimparPalavra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimparPalavraActionPerformed(evt);
            }
        });

        jTA.setColumns(20);
        jTA.setRows(5);
        jScrollPane1.setViewportView(jTA);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFpalavras))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBpesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBlimparPalavra)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFpalavras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBpesquisar)
                    .addComponent(jBlimparPalavra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlerActionPerformed
    String caminho = jTFcaminho.getText().trim();
    if(caminho.isEmpty()){
        jTA.append("Digite um caminho valido!\n");
        return;
    }
    
    File diretorio = new File(caminho);
    if(!diretorio.exists()){
        jTA.append("Diretorio não encontrado");
        return;
    }
    
    if(!diretorio.isDirectory()){
        jTA.append("O caminho não é um diretorio!\n");
    }
    
    mapa = new MapaDispersao<>(101);
    
    explorarDiretorio(diretorio);
    
    jTA.append("Arquivos processados.\n");
    }//GEN-LAST:event_jBlerActionPerformed

    private void jBlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimparActionPerformed
        jTFcaminho.setText("");
        this.mapa = new MapaDispersao<>(101);
    }//GEN-LAST:event_jBlimparActionPerformed

    private void jBpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpesquisarActionPerformed
        String busca = jTFpalavras.getText();
        busca = busca.toLowerCase();

        if (mapa == null) {
            jTA.append("Leia os arquivos primeiro!");
            return;
        }
        if (busca == null) {
            jTA.append("Digite uma ou mais palavras!");
            return;
        }

        String[] palavrasBusca = busca.split("\\s+");

        if (palavrasBusca.length == 1) {
            buscarPalavraUnica(palavrasBusca[0]);
        } else {
            buscarMultiplasPalavras(palavrasBusca);
        }
    }//GEN-LAST:event_jBpesquisarActionPerformed

    private void jBlimparPalavraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimparPalavraActionPerformed
        jTA.setText("");
        jTFpalavras.setText("");
    }//GEN-LAST:event_jBlimparPalavraActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela dialog = new Tela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBler;
    private javax.swing.JButton jBlimpar;
    private javax.swing.JButton jBlimparPalavra;
    private javax.swing.JButton jBpesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTA;
    private javax.swing.JTextField jTFcaminho;
    private javax.swing.JTextField jTFpalavras;
    // End of variables declaration//GEN-END:variables
}
