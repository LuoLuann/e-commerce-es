package ufape.es.catalog.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufape.es.catalog.model.Category;
import ufape.es.catalog.model.Product;
import ufape.es.catalog.cadastro.InterfaceCadastroCategoria;
import ufape.es.catalog.cadastro.InterfaceCadastroProduct;

@Service
public class Catalog {
	@Autowired
	private InterfaceCadastroCategoria cadastroCategoria;
	@Autowired
	private InterfaceCadastroProduct cadastroProduct;
	public Category salvarCategoria(Category entity) {
		return cadastroCategoria.salvarCategoria(entity);
	}
	public List<Category> listarCategorias() {
		return cadastroCategoria.listarCategorias();
	}
	public void apagarCategoria(Long id) {
		cadastroCategoria.apagarCategoria(id);
	}
	public void apagarCategoria(Category entity) {
		cadastroCategoria.apagarCategoria(entity);
	}
	public Category encontrarCategoria(Long id) {
		return cadastroCategoria.encontrarCategoria(id);
	}
	public List<Product> listarProducts(String descricao) {
		return cadastroProduct.listarProducts(descricao);
	}
	public List<Product> listarProductsPorCategoria(String nome) {
		return cadastroProduct.listarProductsPorCategoria(nome);
	}
	public Product salvarProduct(Product entity) {
		return cadastroProduct.salvarProduct(entity);
	}
	public List<Product> listarProducts() {
		return cadastroProduct.listarProducts();
	}
	public Optional<Product> encontrarProductId(Long id) {
		return cadastroProduct.encontrarProductId(id);
	}
	public void apagarProduct(Long id) {
		cadastroProduct.apagarProduct(id);
	}
	public void apagarProduct(Product entity) {
		cadastroProduct.apagarProduct(entity);
	}



}
