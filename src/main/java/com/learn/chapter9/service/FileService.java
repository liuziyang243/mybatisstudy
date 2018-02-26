package com.learn.chapter9.service;

import com.learn.chapter2.util.SqlSessionFactoryUtil;
import com.learn.chapter9.dao.FileMapper;
import com.learn.chapter9.pojo.TFile;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2018-02-26 21:47
 */
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    public static void insert(String path) throws Exception {
        File f = new File(path);
        byte[] bytes = new byte[(int) f.length()];
        try (FileInputStream in = new FileInputStream(f)) {
            in.read(bytes);
        }
        TFile file = new TFile();
        file.setFile(bytes);
        SqlSession session = SqlSessionFactoryUtil.openSqlSession();
        try {
            FileMapper fileMapper = session.getMapper(FileMapper.class);
            fileMapper.insertFile(file);
            logger.info(file.getId().toString());
            session.commit();
        } catch (Exception e) {
            session.rollback();
            logger.error("[error]", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void getFile() {
        SqlSession session = SqlSessionFactoryUtil.openSqlSession();
        try {
            FileMapper fileMapper = session.getMapper(FileMapper.class);
            TFile tFile = fileMapper.getFile(1L);
            logger.info("" + tFile.getFile().length);
        } catch (Exception e) {
            session.rollback();
            logger.error("[error]", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
