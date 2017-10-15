package com.github.haopoboy.util;

import java.util.Set;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;


public class Util {

	static class SkipNullRepresenter extends Representer {
		@Override
		protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
			// if value of property is null, ignore it.
			if (propertyValue == null) {
				return null;
			}  
			else {
				return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
			}
		}
	}

	static class CustomRepresenter extends Representer {
		
		/**
		 * Override to skip type print.
		 */
		@Override
	    protected MappingNode representJavaBean(Set<Property> properties, Object javaBean) {
	        if (!classTags.containsKey( javaBean.getClass()) ) {
	        	addClassTag( javaBean.getClass(), Tag.MAP );
	        }

	        return super.representJavaBean(properties, javaBean);
	    }
		
		/**
		 * Override to skip empty.
		 */
		@Override
		protected NodeTuple representJavaBeanProperty(Object javaBean, Property property,
				Object propertyValue, Tag customTag) {
			NodeTuple tuple = super.representJavaBeanProperty(javaBean, property, propertyValue,
					customTag);
			Node valueNode = tuple.getValueNode();
			if ( Tag.NULL.equals(valueNode.getTag()) ) {
				return null;
			}
			if (valueNode instanceof CollectionNode) {
				if ( Tag.SEQ.equals(valueNode.getTag()) ) {
					SequenceNode seq = (SequenceNode) valueNode;
					if ( seq.getValue().isEmpty() ) {
						return null;
					}
				}
				if ( Tag.MAP.equals(valueNode.getTag()) ) {
					MappingNode seq = (MappingNode) valueNode;
					if ( seq.getValue().isEmpty() ) {
						return null;
					}
				}
			}
			return tuple;
		}
	}

	Util() {}

	public static Yaml createDefaultYaml() {
		Representer representer = new CustomRepresenter();
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(FlowStyle.BLOCK);
		return new Yaml( new SafeConstructor(), representer, options );
	}
}
