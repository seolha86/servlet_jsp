package com.kseolha.jsp.util;

import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.Member;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 자바 리플랙션 -> 프록시 객체 사용
// 다량의 파라미터
// 도움클래스

// 인보케이션
// 파라미터가 없을 때 기본값을 받아오도록
public class ParamSolver {
    public static <T> T getParams(HttpServletRequest req, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.getDeclaredConstructor().newInstance();
            // 선언 필드에 대한 타입 및 이름 체크
            Field[] fields = clazz.getDeclaredFields();
            for(Field f : fields) {
                String fieldName = f.getName();
                String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method[] methods = clazz.getDeclaredMethods();
                for(Method m : methods) {
                    if(setterName.equals(m.getName())) {
                        if(req.getParameter(fieldName) == null) {
                            continue;
                        }
                        if(f.getType() == Integer.class || f.getType() == int.class) {
                            m.invoke(t, Integer.parseInt(req.getParameter(fieldName)));
                        }
                        if(f.getType() == String.class) {
                            m.invoke(t, req.getParameter(fieldName));
                        }
//                        if(f.getType() == String[].class) {
//                            m.invoke(t, (Object)req.getParameter(fieldName));
//                        }
                        if(f.getType() == Long.class || f.getType() == long.class) {
                            m.invoke(t, Long.valueOf(req.getParameter(fieldName)));
                        }
                    }
                }
            }
//            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static boolean isLogin(HttpServletRequest req) {
        return req.getSession().getAttribute("member") != null;
    }

    public static boolean isMine(HttpServletRequest req, String writer) {
        return isLogin(req) && ((Member) req.getSession().getAttribute("member")).getId().equals(writer);
    }

    public static void main(String[] args) {
        getParams(null, Criteria.class);
    }
}
