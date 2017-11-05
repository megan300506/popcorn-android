/*
 * This file is part of Butter.
 *
 * Butter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Butter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Butter. If not, see <http://www.gnu.org/licenses/>.
 */

package butter.droid.ui.media.detail.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UiSubItem implements Parcelable {

    private final String language;
    private final String name;
    private boolean selected;

    public UiSubItem(final String language, final String name, final boolean selected) {
        this.language = language;
        this.name = name;
        this.selected = selected;
    }

    protected UiSubItem(Parcel in) {
        language = in.readString();
        name = in.readString();
        selected = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(language);
        dest.writeString(name);
        dest.writeByte((byte) (selected ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }

    public static final Creator<UiSubItem> CREATOR = new Creator<UiSubItem>() {
        @Override
        public UiSubItem createFromParcel(android.os.Parcel in) {
            return new UiSubItem(in);
        }

        @Override
        public UiSubItem[] newArray(int size) {
            return new UiSubItem[size];
        }
    };
}
