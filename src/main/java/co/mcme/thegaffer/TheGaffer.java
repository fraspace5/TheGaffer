/*  This file is part of TheGaffer.
 * 
 *  TheGaffer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TheGaffer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with TheGaffer.  If not, see <http://www.gnu.org/licenses/>.
 */
package co.mcme.thegaffer;

import co.mcme.jobs.util.Util;
import co.mcme.thegaffer.storage.Job;
import co.mcme.thegaffer.storage.JobWarp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class TheGaffer extends JavaPlugin {

    @Getter
    static Server serverInstance;
    @Getter
    static TheGaffer pluginInstance;
    @Getter
    static File pluginDataFolder;
    @Getter
    static String fileSeperator = System.getProperty("file.separator");
    @Getter
    static ObjectMapper jsonMapper = new ObjectMapper().configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

    @Override
    public void onEnable() {
        serverInstance = getServer();
        pluginInstance = this;
        pluginDataFolder = pluginInstance.getDataFolder();
        Location loc = new Location(serverInstance.getWorlds().get(0), 0, 85, 0);
        JobWarp warp = new JobWarp(loc);
        Job debug = new Job("derpjob", "meggawatts", true, warp, warp.getWorld(), false);
        Util.debug(debug.addHelper(serverInstance.getOfflinePlayer("Credoo")).getMessage());
        try {
            jsonMapper.writeValue(new File(pluginDataFolder + fileSeperator + "test.json"), debug);
        } catch (IOException ex) {
            Logger.getLogger(TheGaffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
