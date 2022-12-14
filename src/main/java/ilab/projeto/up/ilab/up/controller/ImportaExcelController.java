package ilab.projeto.up.ilab.up.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ilab.projeto.up.ilab.up.dto.ColaboradorMatriculaDTO;
import ilab.projeto.up.ilab.up.dto.ContratoNomeDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;
import ilab.projeto.up.ilab.up.model.ColaboradorContrato;
import ilab.projeto.up.ilab.up.model.Contrato;
import ilab.projeto.up.ilab.up.repository.ColaboradorContratoRepository;
import ilab.projeto.up.ilab.up.service.impl.ColaboradorServiceImpl;
import ilab.projeto.up.ilab.up.service.impl.ContratoServiceImpl;
import ilab.projeto.up.ilab.up.service.impl.ImportExcelServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/upload")
public class ImportaExcelController {

	@Autowired
	private ColaboradorServiceImpl colabServiceImpl;

	@Autowired
	private ContratoServiceImpl contratoServiceImpl;

	@Autowired
	private ColaboradorContratoRepository colaboradorContratoRepository;

	@Autowired
	private ImportExcelServiceImpl importExcelServiceImpl;

	@ApiOperation(value = "Enviar arquivo Excel")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Arquivo enviado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@RequestMapping(value = "/excel", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<List<ColaboradorContrato>> uploadExcelFile(@RequestParam("file") MultipartFile file)
			throws IOException {
		HttpStatus status = HttpStatus.OK;

		List<ColaboradorContrato> colaboradorContratoList = new ArrayList<>();
		List<ColaboradorMatriculaDTO> colaboradorMatricula = new ArrayList<>();
		colaboradorMatricula = colabServiceImpl.buscarColaboradorMatricula();
		List<ContratoNomeDTO> contratoNome = new ArrayList<>();
		contratoNome = contratoServiceImpl.buscarContratoNomes();
//		Colaborador colaborador = new Colaborador();

		int numSheet = 0;
		XSSFSheet worksheet = importExcelServiceImpl.lerExcelAba(file, numSheet);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {

				String mat = importExcelServiceImpl.lerCell(worksheet, 0, index);

				String depart = importExcelServiceImpl.lerCell(worksheet, 3, index);

//				String nomeColab = importExcelServiceImpl.lerCell(worksheet, 1, index);

				for (ColaboradorMatriculaDTO colab : colaboradorMatricula) {
					for (ContratoNomeDTO contr : contratoNome) {

//					if (!mat.equals(colab.getMatricula())) {
//						colaborador.setMatricula(mat);
//						colaborador.setNomeColaborador(nomeColab);
//					}

						ColaboradorContrato colaboradorContrato = new ColaboradorContrato();
						colaboradorContrato.setColaborador(new Colaborador());
						colaboradorContrato.setContrato(new Contrato());

						String esf = importExcelServiceImpl.lerCell(worksheet, 5, index);
						int esforcoTotal = importExcelServiceImpl.transform(esf);

						String esfExtra = importExcelServiceImpl.lerCell(worksheet, 6, index);
						int esforcoExtraTotal = importExcelServiceImpl.transform(esfExtra);

						if (mat.equals(colab.getMatricula())) {

							colaboradorContrato.setDataBatida(LocalDateTime.now());
							colaboradorContrato.setIdColaborador(colab.getIdColaborador());
							colaboradorContrato.setEsforcoTotal(esforcoTotal);
							colaboradorContrato.setEsforcoExtraTotal(esforcoExtraTotal);
						}

						if ((mat.equals(colab.getMatricula())) && (depart.equals(contr.getNomeContrato()))) {
							colaboradorContrato.setIdContrato(contr.getIdContrato());
							colaboradorContratoRepository.saveAndFlush(colaboradorContrato);
							colaboradorContratoList.add(colaboradorContrato);
						}
					}

				}
			}
		}

		return new ResponseEntity<List<ColaboradorContrato>>(status);

	}
}
