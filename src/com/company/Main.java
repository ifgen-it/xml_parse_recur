package com.company;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Задания:
 *
 * 1. Необходимо сформировать коллекцию, содержащую все виды документов в отсортированном порядке.
 * 2. Вывести имена и значения всех атрибутов для par step="1" name="ГРАЖДАНСТВО".
 * 3. Задача со звездочкой: создать в базе таблицу-справочник со значениями из первой части.
 *
 * Исходный файл - input.xml
 *
 */

public class Main {

    private static List<String> vidDok = new ArrayList<>();
    private static List<Par> parsFromXml = new ArrayList<>();

    private static void visitChildNodes(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                if (node.getNodeName().equals("par")) {
                    if (node.hasAttributes()) {
                        NamedNodeMap parAttrs = node.getAttributes();

                        // TASK 1 - VID_DOK
                        Node name = parAttrs.getNamedItem("name");
                        if (name.getNodeValue().equals("ВИД_ДОК")) {
                            NodeList parList = ((Element) node).getElementsByTagName("par_list");
                            for (int l = 0; l < parList.getLength(); l++) {
                                Node itemOfList = parList.item(l);
                                String dok = itemOfList.getAttributes().getNamedItem("value").getNodeValue();
                                vidDok.add(dok);
                            }
                            Collections.sort(vidDok);
                            System.out.println("\n>>> TASK 1 : Sorted collection ВИД_ДОК:");
                            System.out.println("=======================================");
                            vidDok.stream().forEach(dok -> System.out.println(dok));
                        }

                        // TASK 2 - GRAZHDANSTVO
                        Node step = parAttrs.getNamedItem("step");
                        if (step.getNodeValue().equals("1") && name.getNodeValue().equals("ГРАЖДАНСТВО")) {
                            System.out.println("\n>>> TASK 2 : Choose all attributes for tag : <par step=\"1\" name=\"ГРАЖДАНСТВО\" .. >:");
                            System.out.println("===================================================================================");
                            for (int at = 0; at < parAttrs.getLength(); at++) {
                                Node attrib = parAttrs.item(at);
                                System.out.println(attrib.getNodeName() + "=\"" + attrib.getNodeValue() + "\"");
                            }
                        }

                        // TASK 3 - SAVE TO OBJECT
                        Par parDto = new Par();
                        parDto.setStep(Integer.parseInt(parAttrs.getNamedItem("step").getNodeValue()));
                        parDto.setName(parAttrs.getNamedItem("name").getNodeValue());
                        parDto.setFullname(parAttrs.getNamedItem("fullname").getNodeValue());
                        parDto.setComment(parAttrs.getNamedItem("comment").getNodeValue());
                        parDto.setEditable(parAttrs.getNamedItem("isEditable").getNodeValue().equals("1"));
                        parDto.setScanable(parAttrs.getNamedItem("isScanable").getNodeValue().equals("1"));
                        parDto.setVisible(parAttrs.getNamedItem("isVisible").getNodeValue().equals("1"));
                        parDto.setRequired(parAttrs.getNamedItem("isRequired").getNodeValue().equals("1"));
                        parDto.setPrinted(parAttrs.getNamedItem("isPrinted").getNodeValue().equals("1"));
                        parDto.setValidateOnLine(parAttrs.getNamedItem("isValidateOnLine").getNodeValue().equals("1"));
                        parDto.setType(parAttrs.getNamedItem("type").getNodeValue());
                        parDto.setMin_length(Integer.parseInt(parAttrs.getNamedItem("min_length").getNodeValue()));
                        parDto.setMax_length(Integer.parseInt(parAttrs.getNamedItem("max_length").getNodeValue()));
                        parDto.setDouble_input(parAttrs.getNamedItem("double_input").getNodeValue().equals("1"));
                        parDto.setValue(parAttrs.getNamedItem("value").getNodeValue());
                        parDto.setReg_exp(parAttrs.getNamedItem("reg_exp").getNodeValue());
                        parDto.setFrom_debt(parAttrs.getNamedItem("from_debt").getNodeValue().equals("1"));

                        if (node.hasChildNodes()) {
                            List<String> strTempParList = new ArrayList<>();
                            NodeList parList = ((Element) node).getElementsByTagName("par_list");
                            for (int l = 0; l < parList.getLength(); l++) {
                                Node itemOfList = parList.item(l);
                                String value = itemOfList.getAttributes().getNamedItem("value").getNodeValue();
                                strTempParList.add(value);
                            }
                            Collections.sort(strTempParList);

                            List<ParList> tempParList = new ArrayList<>();
                            strTempParList.forEach(str -> tempParList.add(new ParList(str)));
                            parDto.setParLists(tempParList);
                        }

                        parsFromXml.add(parDto);
                    }
                }

                if (node.hasChildNodes()) {
                    visitChildNodes(node.getChildNodes());
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(">>> XML Parser started... >>>");
        String xmlFile = "input.xml";

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File(xmlFile));
            document.getDocumentElement().normalize();
            Element tagOrder = document.getDocumentElement();
            NodeList tagsServices = tagOrder.getChildNodes();
            visitChildNodes(tagsServices);

            System.out.println("\n>>> TASK 3 : All objects pars:");
            System.out.println("==============================");
            parsFromXml.stream().forEach(par -> System.out.println(par));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
