package com.github.mgramin.sqlboot.util.template_engine.impl;

import com.github.mgramin.sqlboot.exceptions.SqlBootException;
import com.github.mgramin.sqlboot.util.template_engine.ITemplateEngine;
import freemarker.core.TemplateElement;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by maksim on 01.04.16.
 */
public class FMTemplateEngine implements ITemplateEngine {

    @Override
    public String process(Map<String, Object> variables, String templateText) throws SqlBootException {
        templateText = templateText.replace("!{", "${");
        try {
            Configuration cfg = new Configuration();
            Template template = new Template("templateName", new StringReader(templateText), cfg);
            Writer out = new StringWriter();
            template.process(variables, out);
            return out.toString();
        } catch (TemplateException | IOException e) {
            System.out.println(templateText + "!!!!!!!!!!!!!!!!!!!!!!");
            throw new SqlBootException(e);
        }
    }

    public List<String> getAllProperties(String templateText) throws SqlBootException {
        templateText = templateText.replace("!", "$");
        Configuration cfg = new Configuration();
        Template template = null;

        List<String> result = new ArrayList<>();
        try {
            template = new Template("templateName", new StringReader(templateText), cfg);
            TemplateElement rootTreeNode = template.getRootTreeNode();
            for (int i = 0; i < rootTreeNode.getChildCount(); i++) {
                TemplateModel templateModel = rootTreeNode.getChildNodes().get(i);
                if (!(templateModel instanceof StringModel)) {
                    continue;
                }
                Object wrappedObject = ((StringModel) templateModel).getWrappedObject();
                if (!"DollarVariable".equals(wrappedObject.getClass().getSimpleName())) {
                    continue;
                }

                Object expression = getInternalState(wrappedObject, "expression");
                switch (expression.getClass().getSimpleName()) {
                    case "Identifier":
                        result.add(getInternalState(expression, "name").toString());
                        break;
                    case "DefaultToExpression":
                        result.add(getInternalState(expression, "lho").toString());
                        break;
                    case "BuiltinVariable":
                        break;
                    default:
                        throw new IllegalStateException("Unable to introspect variable");
                }

            }

        } catch (NoSuchFieldException | IllegalAccessException | TemplateModelException | IOException e) {
            throw new SqlBootException("Unable to reflect template model", e);
        }
        return result;
    }

    private Object getInternalState(Object o, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = o.getClass().getDeclaredField(fieldName);
        boolean wasAccessible = field.isAccessible();
        try {
            field.setAccessible(true);
            return field.get(o);
        } finally {
            field.setAccessible(wasAccessible);
        }
    }

}