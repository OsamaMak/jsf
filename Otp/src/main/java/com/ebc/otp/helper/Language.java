
package com.ebc.otp.helper;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for language.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="language"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="EN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "language")
@XmlEnum
public enum Language {

    AR,
    EN;

    public String value() {
        return name();
    }

    public static Language fromValue(String v) {
        return valueOf(v);
    }

}
