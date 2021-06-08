package com.kodq.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	//Converte um parâmetro da URL retirando os espaços do nome caso houver (Aula 51)
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	//Converte uma lista de string em uma lista de Integer (Aula 50)
	public static List<Integer> decodeIntList(String s){
		/*
		 * String [] vet = s.split(","); List<Integer> list = new ArrayList<>();
		 * 
		 * for(int i=0; i<vet.length; i++) { list.add(Integer.parseInt(vet[i])); }
		 * 
		 * return list;
		 */
		
		//Faz a mesma coisa do código acima usando LAMBDA (Aula 50)
		return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
	}

}
