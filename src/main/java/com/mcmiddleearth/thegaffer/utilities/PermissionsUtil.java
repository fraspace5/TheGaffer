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
package com.mcmiddleearth.thegaffer.utilities;

import lombok.Getter;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class PermissionsUtil {

    @Getter
    private static final Permission joinPermission = new Permission("thegaffer.join", PermissionDefault.TRUE);
    
    @Getter
    private static final Permission createPermission = new Permission("thegaffer.create", PermissionDefault.OP);
    
    @Getter
    private static final Permission ignoreWorldProtection = new Permission("thegaffer.ignoreprotection", PermissionDefault.OP);
}
