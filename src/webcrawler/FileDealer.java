package webcrawler;  

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileDealer {

    private ObjectInputStream input;
    private ObjectOutputStream output;

    public void openToWrite(String nomeArq) {
        try {
            FileOutputStream arq = new FileOutputStream(nomeArq);
            output = new ObjectOutputStream(arq);
            System.out.println("Arquivo aberto para escrita");

        } catch (IOException IoException) {
            System.err.println("Erro ao ler o arquivo");
            System.exit(1);
        }
    }

    public void openToRead(String nomeArq) throws IOException {
            FileInputStream arq = new FileInputStream(nomeArq);
            input = new ObjectInputStream(arq);
            System.out.println("Arquivo aberto para leitura");
        
    }

    public void closeAfterRead() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("Arquivo fechado com sucesso.");
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar o arquivo");
            System.exit(1);
        }

    }

    public void closeAfterWrite() {
        try {
            if (output != null) {
                output.close();
                output = null;
                System.out.println("Arquivo fechado com sucesso.");
            } else {
                System.out.println("Arquivo nulo.");
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar o arquivo");
            System.exit(1);
        }
    }

    public void gravaObjeto(Object al) {
        try {
            if (output != null) {
                output.writeObject(al);
                output.flush();
                System.out.println("Arquivo gravado com sucesso.");
            }
        } catch (IOException ioException) {
            System.err.println("Erro ao gravar o arquivo");
            System.exit(1);
        }
    }

    public Object lerObjeto() {
        try {
            if (input != null) {
                return input.readObject();
            }
        } catch (EOFException eofException) {
            System.out.println("Fim de arquivo.");
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar o arquivo");
            return null;
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Erro: classe não encontrada.");
            return null;
        }
        return null;
    }

}