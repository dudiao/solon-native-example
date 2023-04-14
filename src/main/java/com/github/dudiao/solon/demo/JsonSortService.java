package com.github.dudiao.solon.demo;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.snack.ONode;
import org.noear.snack.core.Feature;
import org.noear.snack.core.Options;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author songyinyin
 * @since 2023/4/5 10:34
 */
@Slf4j
@Component
public class JsonSortService implements EventListener<AppLoadEndEvent> {

  private final Options jsonOptions = Options.def().add(Feature.PrettyFormat).add(Feature.OrderedField);

  @Inject()
  private JsonSortConfig config;

  @Override
  public void onEvent(AppLoadEndEvent event) throws IOException {
    try {
      doJsonSort();
    } catch (Throwable e) {
      log.error("doJsonSort error", e);
    }
  }

  private void doJsonSort() throws IOException {
    log.info("json config: {}", config);
    File file = config.getInputFilePath();

//    Charset fileCharset = config.getInputFileCharset() != null ? Charset.forName(config.getInputFileCharset()) : CharsetDetector.detect(file);
    Charset fileCharset = Charset.forName(config.getInputFileCharset());

    String readString = FileUtil.readString(file, fileCharset);
    ONode oNode = ONode.loadStr(readString);

    List<User> users = oNode.toObjectList(User.class);
    log.info("users: {}", users);

    File outputDir = config.getOutputDir();
    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }

    log.info("导出的文件路径：{}", outputDir.getAbsolutePath());
    for (Map.Entry<String, List<User>> entry : users.stream().collect(Collectors.groupingBy(User::getRemark_name)).entrySet()) {
      String k = entry.getKey();
      List<User> v = entry.getValue();
      File jsonFile = new File("%s/%s.json".formatted(outputDir.getAbsolutePath(), k));

      boolean newFile = jsonFile.createNewFile();
      if (!newFile) {
        log.warn("file {} already exists", jsonFile.getAbsolutePath());
      } else {
        log.info("create file {}", jsonFile.getAbsolutePath());
      }

      try {
        ONode load = ONode.load(v, jsonOptions);
        String json = load.toString();
        FileWriter fileWriter = new FileWriter(jsonFile);
        fileWriter.write(json);
        fileWriter.close();
      } catch (Exception e) {
        log.error("write json file error", e);
      }
    }
  }
}
