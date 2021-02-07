package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovasImagensRequest {

	@Size(min =1)
	@NotNull
	List<MultipartFile> imagens = new ArrayList<>();

	public NovasImagensRequest(@Size(min = 1) @NotNull List<MultipartFile> imagens) {
		super();
		this.imagens = imagens;
	}

	public List<MultipartFile> getImages() {
		// TODO Auto-generated method stub
		return imagens;
	}
	
	
}
