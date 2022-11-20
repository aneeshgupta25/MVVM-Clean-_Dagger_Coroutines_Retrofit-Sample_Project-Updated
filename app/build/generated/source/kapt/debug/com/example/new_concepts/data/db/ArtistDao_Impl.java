package com.example.new_concepts.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.new_concepts.data.model.artist.Artist;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ArtistDao_Impl implements ArtistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Artist> __insertionAdapterOfArtist;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllArtists;

  public ArtistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArtist = new EntityInsertionAdapter<Artist>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `popular_artists` (`id`,`name`,`popularity`,`profilePath`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Artist value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPopularity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getPopularity());
        }
        if (value.getProfilePath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProfilePath());
        }
      }
    };
    this.__preparedStmtOfDeleteAllArtists = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM popular_artists";
        return _query;
      }
    };
  }

  @Override
  public Object saveArtists(final List<Artist> artists,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfArtist.insert(artists);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllArtists(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllArtists.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllArtists.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getArtists(final Continuation<? super List<Artist>> continuation) {
    final String _sql = "SELECT * FROM popular_artists";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Artist>>() {
      @Override
      public List<Artist> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfProfilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profilePath");
          final List<Artist> _result = new ArrayList<Artist>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Artist _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Double _tmpPopularity;
            if (_cursor.isNull(_cursorIndexOfPopularity)) {
              _tmpPopularity = null;
            } else {
              _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            }
            final String _tmpProfilePath;
            if (_cursor.isNull(_cursorIndexOfProfilePath)) {
              _tmpProfilePath = null;
            } else {
              _tmpProfilePath = _cursor.getString(_cursorIndexOfProfilePath);
            }
            _item = new Artist(_tmpId,_tmpName,_tmpPopularity,_tmpProfilePath);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
