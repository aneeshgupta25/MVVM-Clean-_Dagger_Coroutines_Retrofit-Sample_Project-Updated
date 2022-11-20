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
import com.example.new_concepts.data.model.tvshow.TvShow;
import java.lang.Class;
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
public final class TvShowsDao_Impl implements TvShowsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TvShow> __insertionAdapterOfTvShow;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTvShows;

  public TvShowsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTvShow = new EntityInsertionAdapter<TvShow>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `popular_tvShows` (`id`,`firstAirDate`,`name`,`overview`,`posterPath`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TvShow value) {
        stmt.bindLong(1, value.getId());
        if (value.getFirstAirDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstAirDate());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getPosterPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPosterPath());
        }
      }
    };
    this.__preparedStmtOfDeleteAllTvShows = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM popular_tvShows";
        return _query;
      }
    };
  }

  @Override
  public Object saveTvShows(final List<TvShow> tvShows,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTvShow.insert(tvShows);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllTvShows(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTvShows.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllTvShows.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getTvShows(final Continuation<? super List<TvShow>> continuation) {
    final String _sql = "SELECT * FROM popular_tvShows";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TvShow>>() {
      @Override
      public List<TvShow> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstAirDate = CursorUtil.getColumnIndexOrThrow(_cursor, "firstAirDate");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "posterPath");
          final List<TvShow> _result = new ArrayList<TvShow>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TvShow _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFirstAirDate;
            if (_cursor.isNull(_cursorIndexOfFirstAirDate)) {
              _tmpFirstAirDate = null;
            } else {
              _tmpFirstAirDate = _cursor.getString(_cursorIndexOfFirstAirDate);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final String _tmpPosterPath;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPosterPath = null;
            } else {
              _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            }
            _item = new TvShow(_tmpId,_tmpFirstAirDate,_tmpName,_tmpOverview,_tmpPosterPath);
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
