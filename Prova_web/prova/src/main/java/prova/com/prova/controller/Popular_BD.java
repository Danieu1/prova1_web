package prova.com.prova.controller;

import prova.com.prova.DAO.LivroDAO;
import prova.com.prova.model.Livro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Popular_BD {

    @GetMapping("/config")
    public void doRemoverCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        private String Nome;
        private String Autor;
        private int ISBN;   //id
        private  float Preco;
        private String Editora;
        private String Genero;
     */
        Livro livro1 = new Livro("Harry potter 1", "JK", 111, 50, "paper_tea", "romace");
        Livro livro2 = new Livro("Harry potter 2", "JK", 222, 50, "paper_tea", "romace");
        Livro livro3 = new Livro("Harry potter 3", "JK", 333, 50, "paper_tea", "romace");
        Livro livro4 = new Livro("Harry potter 4", "JK", 444, 50, "paper_tea", "romace");
        Livro livro5 = new Livro("Harry potter 5", "JK", 555, 50, "paper_tea", "romace");
        Livro livro6 = new Livro("Harry potter 6", "JK", 666, 50, "paper_tea", "romace");
        



        try {
            LivroDAO.criarTabela();
        }catch (Exception e){
            System.out.println(e);
        }


        try {

            LivroDAO.inserir(livro1);
            LivroDAO.inserir(livro2);
            LivroDAO.inserir(livro3);
            LivroDAO.inserir(livro4);
            LivroDAO.inserir(livro5);
            var writer = response.getWriter();
            writer.println("sucesso na criação e população de banco de dados");
        } catch (Exception e){

            var writer = response.getWriter();
            writer.println("fracaçou!");
        }

    }
}
