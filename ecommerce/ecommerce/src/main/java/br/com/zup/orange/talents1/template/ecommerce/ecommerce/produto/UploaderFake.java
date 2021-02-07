package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Primary
public class UploaderFake implements Uploader{

	/**
	 * 
	 * @param imagens
	 * @return link para imagens de uploads
	 */
	public Set<String> envia(List<MultipartFile> imagens){
		return imagens.stream()
				.map(imagem -> "http://bucket.io/ "
						+imagem.getOriginalFilename() + " - "
						+ UUID.randomUUID().toString())
				.collect(Collectors.toSet());
	}
}
