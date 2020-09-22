package me.hsgamer.hscore.bukkit.config.path;

import me.hsgamer.hscore.config.SerializableMapConfigPath;
import org.bukkit.potion.PotionEffect;

import java.util.Map;

public final class PotionEffectConfigPath extends SerializableMapConfigPath<PotionEffect> {

  /**
   * Create a config path
   *
   * @param path the path to the value
   * @param def  the default value if it's not found
   */
  public PotionEffectConfigPath(String path, PotionEffect def) {
    super(path, def);
  }

  @Override
  public PotionEffect convert(Map<String, Object> rawValue) {
    return new PotionEffect(rawValue);
  }

  @Override
  public Map<String, Object> convertToRaw(PotionEffect value) {
    return value.serialize();
  }
}
