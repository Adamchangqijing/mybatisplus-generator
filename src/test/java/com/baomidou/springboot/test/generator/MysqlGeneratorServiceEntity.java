package com.baomidou.springboot.test.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class MysqlGeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.hxgis.commons";
        boolean serviceNameStartWithI = true;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName,
               "zone_file"
        );
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        //todo mysql
        String dbUrl = "jdbc:mysql://10.104.235.44:3306/disaster_survey?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=CTT";
        //todo oracle
//        String dbUrl = "jdbc:oracle:thin:@10.104.235.44:1521:ORCL";
        //todo xugu
//        String dbUrl = "jdbc:xugu://10.104.207.222:5138/MDOS";

//        //todo postgres
//        String dbUrl = "jdbc:postgresql://10.104.131.36:5432/zhpc?currentSchema=SCHEM";


        DataSourceConfig dataSourceConfig = new DataSourceConfig();

//        dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
//                if ("timestamp".equals(fieldType.toLowerCase())) return DbColumnType.TIMESTAMP;
//                if ("datetime".equals(fieldType.toLowerCase())) return DbColumnType.TIMESTAMP;
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                return super.processTypeConvert(globalConfig, fieldType);
//            }
//        });

//        todo mysql
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("Huawei12#$")
                .setDriverName("com.mysql.jdbc.Driver");
        //oracle
//        dataSourceConfig.setDbType(DbType.ORACLE)
//                .setUrl(dbUrl)
//                .setUsername("CJJY")
//                .setPassword("CJJY")
//                .setDriverName("oracle.jdbc.driver.OracleDriver");
        //todo xugu
//        IDbQuery iDbQuery = new XuguQuery();
//        dataSourceConfig.setDbType(DbType.XU_GU).setDbQuery(iDbQuery)
//                .setUrl(dbUrl)
//                .setUsername("USR_SOD")
//                .setPassword("Pnmic_xg2019")
//                .setDriverName("com.xugu.cloudjdbc.Driver");

//        //todo POSTGRE_SQL
//        dataSourceConfig.setDbType(DbType.POSTGRE_SQL)
//                .setUrl(dbUrl)
//                .setUsername("zhpc")
//                .setPassword("zhpc")
//                .setSchemaName("public")
//                .setDriverName("org.postgresql.Driver");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                //todo 这里看实体继承要不要
//                .setSuperEntityClass("com.hxgis.esfullsearch.common.base.BaseEntity")
//                .setSuperEntityColumns(new String[] { "id", "create_time", "update_time", "create_user", "update_user"})
//                .setSuperMapperClass("com.hxgis.esfullsearch.common.base.BaseMapper")
//                .setSuperServiceClass("com.hxgis.esfullsearch.common.base.service.BaseService")
//                .setSuperServiceImplClass("com.hxgis.esfullsearch.common.base.service.impl.BaseServiceImpl")
//                .setSuperControllerClass("com.hxgis.esfullsearch.common.base.BaseController")
                .setRestControllerStyle(true)//设置成restController
                .setEntityLombokModel(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setNaming(NamingStrategy.underline_to_camel)
//                .setNaming(NamingStrategy.no_change)
                .setEntityColumnConstant(true) //生成字段常量
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setAuthor("cqj").setSwagger2(true)
                .setOutputDir("E:\\work\\lianchuang\\disaster-survey\\commons\\src\\main\\java")
//                .setOutputDir("D:\\test")
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
            config.setControllerName("%sController");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setService("service")
                                .setServiceImpl("service.impl")
                                .setController("controller")
                                .setEntity("model.entity")
                                .setMapper("dao")
                                .setXml("mapper")
                ).execute();

    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
