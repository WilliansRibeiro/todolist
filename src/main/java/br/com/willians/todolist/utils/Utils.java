package br.com.willians.todolist.utils;

import java.beans.PropertyDescriptor;  // Importa a classe PropertyDescriptor para lidar com propriedades de objetos
import java.util.HashSet;  // Importa a classe HashSet para armazenar nomes de propriedades nulas
import java.util.Set;  // Importa a classe Set para manter um conjunto de nomes de propriedades nulas

import org.springframework.beans.BeanUtils;  // Importa classes do Spring Framework para trabalhar com propriedades de objetos
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {  // Declara uma classe chamada Utils

    public static void copyNonNullProperties(Object source, Object target){
        // Método para copiar propriedades não nulas do objeto de origem para o objeto de destino
        // Argumentos: source - objeto de origem, target - objeto de destino
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        // Usa o BeanUtils do Spring para copiar propriedades, excluindo as propriedades nulas
    }

    public static String[] getNullPropertyNames(Object source){
        // Método para obter os nomes das propriedades nulas de um objeto
        // Argumento: source - objeto do qual obter os nomes das propriedades nulas

        final BeanWrapper src = new BeanWrapperImpl(source);  // Cria um BeanWrapper com o objeto de origem
        PropertyDescriptor[] pds = src.getPropertyDescriptors();  // Obtém as descrições de propriedades do objeto

        Set<String> emptyNames = new HashSet<>();  // Cria um conjunto para armazenar os nomes de propriedades nulas

        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());  // Obtém o valor da propriedade atual
            if (srcValue == null) {
                emptyNames.add(pd.getName());  // Se o valor for nulo, adiciona o nome da propriedade ao conjunto
            }
        }

        String[] result = new String[emptyNames.size()];  // Cria um array de strings para armazenar os nomes das propriedades nulas
        return emptyNames.toArray(result);  // Converte o conjunto de nomes em um array e o retorna
    }
}
