package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.visitors.PlaylistVisitor;

public interface PlaylistItem {
	public static Double BAND_PER_SECOND = 1.5;
	<T> T accept(PlaylistVisitor<T> visitor);
}

