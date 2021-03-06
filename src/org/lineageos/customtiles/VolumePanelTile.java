/*
 * Copyright (C) 2017 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lineageos.customtiles;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class VolumePanelTile extends TileService {

    @Override
    public void onStartListening() {
        super.onStartListening();

        refresh();
    }

    @Override
    public void onClick() {
        super.onClick();

        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        am.adjustVolume(AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
    }

    private void refresh() {
        getQsTile().setIcon(Icon.createWithResource(this, R.drawable.ic_volume_panel));
        getQsTile().setState(Tile.STATE_ACTIVE);
        getQsTile().updateTile();
    }

}
