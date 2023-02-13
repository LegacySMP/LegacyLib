package pro.nocom.legacysmp.legacylib.util.impl;

import org.bukkit.entity.*;
import pro.nocom.legacysmp.legacylib.util.Utility;

import javax.annotation.Nullable;

public final class EntityUtil extends Utility {
    public static @Nullable CreatureType getCreatureType(final LivingEntity entity) {
        if (entity instanceof Chicken) {
            return CreatureType.CHICKEN;
        }

        if (entity instanceof Cow) {
            return CreatureType.COW;
        }

        if (entity instanceof Creeper) {
            return CreatureType.CREEPER;
        }

        if (entity instanceof Ghast) {
            return CreatureType.GHAST;
        }

        if (entity instanceof Giant) {
            return CreatureType.GIANT;
        }

        if (entity instanceof Wolf) {
            return CreatureType.WOLF;
        }

        if (entity instanceof Pig) {
            return CreatureType.PIG;
        }

        if (entity instanceof PigZombie) {
            return CreatureType.PIG_ZOMBIE;
        }

        if (entity instanceof Sheep) {
            return CreatureType.SHEEP;
        }

        if (entity instanceof Skeleton) {
            return CreatureType.SKELETON;
        }

        if (entity instanceof Slime) {
            return CreatureType.SLIME;
        }

        if (entity instanceof Spider) {
            return CreatureType.SPIDER;
        }

        if (entity instanceof Squid) {
            return CreatureType.SQUID;
        }

        if (entity instanceof Zombie) {
            return CreatureType.ZOMBIE;
        }

        if (entity instanceof Monster) {
            return CreatureType.MONSTER;
        }

        return null;
    }
}
